package com.interview.brushups.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;

public class SparkRDDWordCount {
    public static void main(String[] args) {

        /**
         * It allows your Spark Application to access Spark Cluster with the help of Resource Manager (YARN/Mesos).
         * To create SparkContext, first SparkConf should be made.
         *
         *  The SparkConf has a configuration parameter that our Spark driver application will pass to SparkContext.
         */
        SparkConf conf =new SparkConf().setMaster("local").setAppName("SparkRDDWordCount");

        JavaSparkContext javaSparkContext = new JavaSparkContext(conf);

        JavaRDD<String> inputData = javaSparkContext.textFile(System.getProperty("user.dir")+"/src/main/resources/notes/bigdata/hadoop.md");

        JavaRDD<String> words = inputData.flatMap(line -> Arrays.asList(line.split(" ")).iterator());
        JavaPairRDD<String,Integer> wordMapTo1 = words.mapToPair(word -> new Tuple2<String,Integer>(word,1));

        /*
         The above code can also be simplified an written as below.
         JavaPairRDD<String,Integer> flattenPairs = inputData.flatMapToPair(text -> Arrays.asList(text.split(" "))
         .stream().map(word -> new Tuple2<String, Integer>(word,1))
         .iterator());
        */

        JavaPairRDD<String, Integer> wordCountRDD = wordMapTo1.reduceByKey((v1,v2) -> v1 + v2);
        wordCountRDD.saveAsTextFile(System.getProperty("user.dir")+"/src/main/resources/output/spark/wordcount");
    }
}