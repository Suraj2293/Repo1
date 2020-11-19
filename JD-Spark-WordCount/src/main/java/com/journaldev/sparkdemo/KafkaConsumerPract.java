package com.journaldev.sparkdemo;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class KafkaConsumerPract {

	public static void main(String[] args) {
		Properties props = new Properties();
	     props.put("bootstrap.servers", "localhost:9092");
	     props.put("group.id", "group4");
	     
	     props.put("enable.auto.commit", "false");
	     props.put("auto.offset.reset", "earliest");
	   props.put("auto.commit.interval.ms", "1000");
	    props.put("session.timeout.ms", "30000");
	     props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	     props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	     Consumer<String, String> consumer = new KafkaConsumer<>(props);
	     consumer.subscribe(Arrays.asList("practise2"));
	     while (true) {
	         ConsumerRecords<String, String> records = consumer.poll(100);
	         for (ConsumerRecord<String, String> record : records)
	             System.out.println("offset ="+ record.offset()+ " key ="+record.key()+ " value ="+record.value());
	     }

	}

}

//If you use Kafka version older than 0.9, you have to replace earliest, latest with smallest,largest.
// we r using 0.10 so need to use earliest, latest
// for earliest we will get offset msg from beginning when we change the group id t0 new one but for the lastest we wont get msg even if we changed the group id 
//it willl fetch only when we start inserting data into topic from producer means latest data only