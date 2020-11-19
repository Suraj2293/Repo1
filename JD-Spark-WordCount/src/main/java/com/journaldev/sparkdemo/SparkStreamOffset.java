package com.journaldev.sparkdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka010.ConsumerStrategies;
import org.apache.spark.streaming.kafka010.HasOffsetRanges;
import org.apache.spark.streaming.kafka010.KafkaUtils;
import org.apache.spark.streaming.kafka010.LocationStrategies;
import org.apache.spark.streaming.kafka010.OffsetRange;


public class SparkStreamOffset {

	static String topics="offset1,offset2";
	static String brokers="localhost:9092";
	static Map<String,Long> m=new HashMap<String,Long>();
	
	//main method
	public static void main(String[] args) {
	SparkConf sc=new SparkConf().setMaster("local[2]").setAppName("Counter1");
	JavaStreamingContext javaStreamingContext=new JavaStreamingContext(sc,Durations.seconds(30));
	
	KafkaDTO kd=new KafkaDTO();
	kd.setOffsets(3L);
	kd.setPartition(3);
	kd.setTopic("offset1");
	
/*	KafkaDTO kd1=new KafkaDTO();
	kd1.setOffsets(0L);
	kd1.setPartition(3);
	kd1.setTopic("offset2");*/
	
	List<KafkaDTO>	resultSet = new ArrayList<KafkaDTO>();
//	resultSet.add(kd);
	//resultSet.add(kd1);
		JavaDStream<ConsumerRecord<String, String>> txnStreamRulesExe =getStreamData(javaStreamingContext, m);
		txnStreamRulesExe
				.foreachRDD(new VoidFunction<JavaRDD<ConsumerRecord<String, String>>>() {
					private static final long serialVersionUID = 1L;

					@Override
					public void call(JavaRDD<ConsumerRecord<String, String>> r)
							throws Exception {

						OffsetRange[] offsetRanges = ((HasOffsetRanges) r.rdd())
								.offsetRanges();
						JavaRDD<String> txnStreamRulesExe1 = r.map(f1);
					//	System.out.println("result:::::::"+txnStreamRulesExe1.collect());
						Long fromOffset = null;
						Long toOffset = null;
						String topic = "";
						Integer partition = null;
						for (OffsetRange offset : offsetRanges) {
							fromOffset = offset.fromOffset();
							toOffset = offset.untilOffset();
							topic = offset.topic();
							partition = offset.partition();
							m.put(topic+"#"+partition,toOffset);
							System.out.println(topic+"#"+partition+"   "+toOffset);
						}

					}

				});
		
		javaStreamingContext.start();
		try {
			javaStreamingContext.awaitTermination();
		} catch (InterruptedException e) {
			
		}
	}
	
	public static JavaInputDStream<ConsumerRecord<String, String>> getStreamData(
			JavaStreamingContext javaStreamingContext,
			Map<String,Long> m) {

		List<String> topicsSet = new ArrayList<String>(Arrays.asList(topics
				.split(",")));
		Map<TopicPartition, Long> fromOffsets = new HashMap<>();
		Map<String, Object> kafkaParams = new HashMap<>();
		kafkaParams.put("bootstrap.servers", brokers);
		kafkaParams.put("key.deserializer", StringDeserializer.class);
		kafkaParams.put("value.deserializer", StringDeserializer.class);
		kafkaParams.put("enable.auto.commit", false);
		kafkaParams.put("auto.offset.reset", "earliest");
		kafkaParams.put("group.id", "test");
		if(m.isEmpty()){
			for (String topic : topicsSet) {
				for (int i = 0; i < 3; i++) {
					m.put(topic+"#"+i,0L);
					fromOffsets.put(new TopicPartition(topic, i), (long) 0);
				}
			}
		}else{
			
			for(String map:m.keySet()){
				fromOffsets.put(new TopicPartition(map.split("#")[0],
						Integer.parseInt(map.split("#")[1])), m.get(map));
			}
		}
	/*	if (!selectOffsetsFromYourDatabase.isEmpty()) {
			for (KafkaDTO resultSet : selectOffsetsFromYourDatabase) {
				fromOffsets.put(new TopicPartition(resultSet.getTopic(),
						resultSet.getPartition()), resultSet.getOffsets());
			}
		} else {
			for (String topic : topicsSet) {
				KafkaOffsetDaoImpl kafkaOffsetInsert = new KafkaOffsetDaoImpl(
						clientProp);
				Integer numberofPartitions = kafkaOffsetInsert
						.getPartitions(topic);
				// log.info("The number of partiions are :" +
				// numberofPartitions);

				for (int i = 0; i < 3; i++) {
					fromOffsets.put(new TopicPartition(topic, i), (long) 0);
				}
			}
		}*/
		JavaInputDStream<ConsumerRecord<String, String>> messages = KafkaUtils
				.createDirectStream(
						javaStreamingContext,
						LocationStrategies.PreferConsistent(),
						ConsumerStrategies.<String, String> Assign(
								fromOffsets.keySet(), kafkaParams, fromOffsets));

		return messages;
	}
	static Function<ConsumerRecord<String, String>, String> f1 = new Function<ConsumerRecord<String, String>, String>() {
		private static final long serialVersionUID = 1L;

		@Override
		public String call(ConsumerRecord<String, String> record)
				throws Exception {
			return record.value();

		}

	};
}
