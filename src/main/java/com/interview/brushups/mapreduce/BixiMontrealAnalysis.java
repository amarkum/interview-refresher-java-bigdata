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

public class BixiMontrealAnalysis {

    public static void main(String args[]) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf,"bix-montreal-job");

        job.setJarByClass(BixiMontrealAnalysis.class);
        job.setMapperClass(BixiMapper.class);

        //job.setCombinerClass(BixiReducer.class);
        job.setReducerClass(BixiReducer.class);

        job.setMapOutputKeyClass(IntWritable.class);
        job.setMapOutputValueClass(IntWritable.class);

        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(LongWritable.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }

    public static class BixiMapper extends Mapper<LongWritable, Text, IntWritable, IntWritable> {
        public void map(LongWritable offset, Text line, Context context) throws IOException, InterruptedException {
            String csvAttributes[] = line.toString().split(",");
            int isMember = 0;
            int duration = 0;
            try {
                duration = Integer.parseInt(csvAttributes[4]); //345
                isMember = Integer.parseInt(csvAttributes[5]); //0 or 1
            } catch (Exception e) {
                // System.out.println("Will Emit 0,0");
            }
            System.out.println("isMember : " + isMember + "duration : " + duration);

            context.write(new IntWritable(isMember), new IntWritable(duration));
        }
    }

    public static class BixiReducer extends Reducer<IntWritable, IntWritable, IntWritable, LongWritable> {
        public void reduce(IntWritable isMember, Iterable<IntWritable> combinedDurationByIsMember, Context context) throws IOException, InterruptedException {

            long sum = 0L;
            int isMemType = isMember.get();
            for (IntWritable duration : combinedDurationByIsMember) {
                sum = sum + (long) duration.get();
            }
            System.out.println("isMemType : " + isMemType + "sum : " + sum);
            context.write(new IntWritable(isMemType), new LongWritable(sum));
        }
    }

}