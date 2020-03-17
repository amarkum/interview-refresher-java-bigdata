package com.interview.brushups.mapreduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.util.StringTokenizer;

public class WordCountMapReduce {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        /**
         * Create a new Configuration, add up whatever the values required in configuration.
         */
        Configuration conf = new Configuration();
        /**
         * Create a new Job Instance, get a new Job Instance via getInstance()
         */
        Job job = Job.getInstance(conf,"word-count-job");
        job.setMapperClass(WordCountMapper.class);
        job.setCombinerClass(WordCountReducer.class);
        job.setReducerClass(WordCountReducer.class);
        job.setJarByClass(WordCountMapReduce.class);

        /**
         * Set the output key and value class
         */
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        /**
         * Set the input and output path,
         */
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }

    public static class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
        public void map(LongWritable offset, Text line, Context context) throws IOException, InterruptedException {
            StringTokenizer iterator = new StringTokenizer(line.toString());
            while (iterator.hasMoreTokens()) {
                Text word = new Text(iterator.nextToken());
                context.write(word, new IntWritable(1));
            }
        }
    }

    public static class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
        public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
            int sum = 0;
            for (IntWritable value : values) {
                sum = sum + value.get();
            }
            context.write(key, new IntWritable(sum));
        }
    }
}
