package com.interview.brushups.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Scanner;

public class ProducerClient {

    public static void main(String args[]) throws Exception{

        int count=0;

        //Assign topicName to string variable
        String topicName = "hello-topic";

        // create instance for properties to access producer configs
        Properties props = new Properties();

        //Assign localhost id
        props.put("bootstrap.servers", "localhost:9092");

        //Set acknowledgements for producer requests.
        props.put("acks", "all");

        //If the request fails, the producer can automatically retry,
        props.put("retries", 10000000);

        //Specify buffer size in config
        //props.put("batch.size", 163084);
        props.put("linger.ms", 1000);

        //Reduce the no of requests less than 0
        props.put("linger.ms", 1);

        props.put("enable.idempotence", true);

        //The buffer.memory controls the total amount of memory available to the producer for buffering.
        props.put("buffer.memory", 33554432);

        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        org.apache.kafka.clients.producer.Producer<String, String> producer = new KafkaProducer<String, String>(props);

        boolean valid = true;

        while(valid) {
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter # of msg to produce");
            String number = myObj.nextLine();  // Read user input
            int num = Integer.valueOf(number);
            for(int i = 1; i <= num; i++) {
                count++;
                System.out.println("Key : "+count + " | Value : "+"Message "+Integer.toString(count));
                producer.send(new ProducerRecord<String, String>(topicName, Integer.toString(count), "Message "+Integer.toString(count)));
                producer.close();
            }
        }

    }
}
