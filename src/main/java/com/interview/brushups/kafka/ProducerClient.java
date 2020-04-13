package com.interview.brushups.kafka;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.Scanner;

public class ProducerClient {

    public static void main(String args[]) throws Exception {

        // create instance for properties to access producer configs
        Properties props = new Properties();

        //Assign localhost id
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        //Set acknowledgements for producer requests.
        props.put(ProducerConfig.ACKS_CONFIG, "all");

        //If the request fails, the producer can automatically retry,
        props.put(ProducerConfig.RETRIES_CONFIG, 10000000);

        //Specify buffer size in config
        props.put(ProducerConfig.LINGER_MS_CONFIG, 1000);

        //The buffer.memory controls the total amount of memory available to the producer for buffering.
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // Create a Kafka Producer, put in the configuration properties.
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);

        //Assign topicName to string variable
        String topicName = "hello-topic";

        Scanner scanner = new Scanner(System.in); // Create a Scanner object
        System.out.println("Enter # of msg to produce");
        Integer number = scanner.nextInt(); // Read user input

        int count = 0;
        for (int i = 1; i <= number; i++) {
            count++;

            //Create a new Producer Record | (topicName, Value) OR (topicName, Key, Value)
            ProducerRecord<String, String> record;
            record = new ProducerRecord(topicName, Integer.toString(count), "Hello " + count);

            // Handle sent records
            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if (e != null) {
                        System.out.println("Record Sent Failed");
                    } else {
                        System.out.println("Topic :" + recordMetadata.topic());
                        System.out.println("Partition :" + recordMetadata.partition());
                        System.out.println("Offset :" + recordMetadata.offset());
                        System.out.println("TimeStamp :" + recordMetadata.timestamp());
                    }
                }
            });
        }
        producer.close();
    }
}