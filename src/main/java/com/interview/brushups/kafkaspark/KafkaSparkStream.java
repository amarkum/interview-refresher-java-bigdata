package com.interview.brushups.kafkaspark;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.spark.SparkConf;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka010.ConsumerStrategies;
import org.apache.spark.streaming.kafka010.KafkaUtils;
import org.apache.spark.streaming.kafka010.LocationStrategies;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class KafkaSparkStream {

    public static void main(String[] args) throws InterruptedException {
        Map<String, Object> kafkaParams = new HashMap<>();
        kafkaParams.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        kafkaParams.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        kafkaParams.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        kafkaParams.put(ConsumerConfig.GROUP_ID_CONFIG, "consumer-group");
        kafkaParams.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);

        kafkaParams.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        kafkaParams.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        kafkaParams.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "300000");

        Collection<String> topics = Arrays.asList("test-topic");

        SparkConf sparkConf = new SparkConf();
        sparkConf.setMaster("local[*]");
        sparkConf.setAppName("MessageLoggingApp");

        JavaStreamingContext streamingContext = new JavaStreamingContext(sparkConf, Durations.seconds(1));
        JavaInputDStream<ConsumerRecord<String, String>> inputDStream = KafkaUtils.createDirectStream(streamingContext, LocationStrategies.PreferConsistent(), ConsumerStrategies.<String, String>Subscribe(topics, kafkaParams));

        inputDStream.foreachRDD(rdd -> {
            rdd.foreach(record ->
                    System.out.printf("partition = %d, offset = %d, key = %s, value = %s\n",
                            record.partition(),
                            record.offset(),
                            record.key(),
                            record.value()));
        }
        );

        streamingContext.start();
        streamingContext.awaitTermination();
    }
}

