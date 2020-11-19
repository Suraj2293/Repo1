package com.journaldev.sparkdemo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import kafka.serializer.StringDecoder;
import static org.apache.spark.sql.functions.*;
import org.apache.avro.ipc.CallFuture;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.functions;
import org.apache.spark.sql.types.DataType;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.Seconds;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaPairInputDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

import scala.Tuple1;
import scala.Tuple2;

import com.google.common.collect.ImmutableList;

public class SparkStreaming {

	static String topics="practise1";
	static String brokers="localhost:9092";
	
	public static void main(String[] args) {
		practise();
	}
	/* static Function<Tuple2<String, String>, String> func1 =
		      new Function<Tuple2<String, String>, String>() {

		        private static final long serialVersionUID = 1L;

		        @Override
		        public String call(Tuple2<String, String> tuple2) {
		          return tuple2._2();
		        }
		      };
*/

		/*  public static JavaDStream<String> getStreamData(JavaStreamingContext javaStreamingContext){
		    Set<String> topicsSet = new HashSet<>(Arrays.asList(topics.split(",")));
		    Map<String, String> kafkaParams = new HashMap<>();
		    kafkaParams.put("metadata.broker.list", brokers);

		    JavaPairInputDStream<String, String> messages =
		        KafkaUtils.createDirectStream(javaStreamingContext, String.class, String.class,
		            StringDecoder.class, StringDecoder.class, kafkaParams, topicsSet);
            System.out.println("message::::::::::::"+messages.toString());
		    JavaDStream<String> txnStreamRulesExe = messages.map(s -> s._2);
		    
	//	    txnStreamRulesExe.print();
		    return txnStreamRulesExe;
		  }*/
		  
		  
		  static Function<Row, String> fun=new Function<Row, String>() {
			
			@Override
			public String call(Row v1) throws Exception {
				return v1.getString(0);
			}
		};
	public static void practise(){
		
		SparkConf sc=new SparkConf().setMaster("local[2]").setAppName("Counter");
	//	JavaSparkContext jsc=new JavaSparkContext(sc);
		
		JavaStreamingContext jstc=new JavaStreamingContext(sc,Durations.seconds(10));
		//JavaReceiverInputDStream<String> lines=jstc.socketTextStream("localhost", 7001);
		/*JavaDStream<String> lines=getStreamData(jstc);
		
		JavaPairDStream<String, Integer> words=lines.flatMap(s -> Arrays.asList(s.split(" "))).mapToPair(s -> new Tuple2(s, 1));
		JavaPairDStream<String, Integer> list =words.reduceByKey((a,b)-> (a+b));
	//	System.out.println("list");
		
		Function2<Integer, Integer, Integer> reduceFunc = new Function2<Integer, Integer, Integer>() {
			  @Override public Integer call(Integer i1, Integer i2) {
			    return i1 + i2;
			  }
			};
		JavaPairDStream<String, Integer> jp=words.reduceByKeyAndWindow(reduceFunc,Durations.seconds(30), Durations.seconds(10));
		System.out.println("dstream ============");
		list.print();
	//	list.print();
		System.out.println("window ============");
		//jp.print();
		jstc.start();
		jstc.awaitTermination();*/
		
		
	//	SQLContext sqlc=new SQLContext(jsc);
		
		/*	List<Person> p=Arrays.asList(new Person("suraj",12),new Person("suraj1",13));
		List<Person> p1= ImmutableList.of(new Person("suraj",12),new Person("suraj1",13));
		
		List<Person> p3=jsc.parallelize(p1).collect();
		for(Person list:p3){
			System.out.println(list.getAge());
		}*/
		
		
		/*JavaRDD<String> people1=jsc.textFile("/home/suraj/Documents/input.txt");
		people1.getNumPartitions();
		String schemaString="name age";
		String[] array=schemaString.split(" ");
		List<StructField> list=new ArrayList<StructField>();
		for(String a:array){
			list.add(DataTypes.createStructField(a, DataTypes.StringType, true));
			
		} 
		
		StructType schema=DataTypes.createStructType(list);
		JavaRDD<Row> r=people1.map(new Function<String, Row>() {

			@Override
			public Row call(String v1) throws Exception {
				return RowFactory.create(v1.split(" ")[0],v1.split(" ")[1]);
			}
			
			
		});
		DataFrame df=sqlc.createDataFrame(r, schema);
		
		DataFrame df1=sqlc.read().json("/home/suraj/Music/sample.json");
		df1.select("id","name").write().format("json").save("abc.json");
		JavaStreamingContext ssc = new JavaStreamingContext(sc, Durations.seconds(1));*/
//		df1.show();
	//	sqlc.udf().register("ud",(String s1,Integer i) ->Integer.parseInt(s1), DataTypes.IntegerType);
/*		
		DataFrame df1=sqlc.read().json("/home/suraj/Music/sample.json");
		DataFrame df2=df1.withColumn("age1",df1.col("name"));
		df2.show();*/
		
		//df2.show();
		
		
		
		
		/*JavaRDD<Person> people=jsc.textFile("/home/suraj/Documents/input.txt").map(new Function<String, Person>() {

			@Override
			public Person call(String v1) throws Exception {
				String s[]=v1.split(" ");
				Person p=new Person();
				p.setAge(Integer.parseInt(s[0]));
				p.setName(s[1]);
				return p;
			}
			
		});
		
		DataFrame df=sqlc.createDataFrame(people, Person.class);
		df.select(df.col("dsds"),df.col("xx"));
		df.registerTempTable("person");
		DataFrame df1=sqlc.sql("select name from person");
		List<String> teenagerNames = df1.toJavaRDD().map(new Function<Row, String>() {
			  public String call(Row row) {
			    return "Name: " + row.getString(0);
			  }
			}).collect();
		
		System.out.println("people"+teenagerNames);
		*/
		
		
		
	/*	DataFrame df=sqlc.read().json("/home/suraj/Music/sample.json");
	df.filter(df.col("id").gt(2)).show();
		df.registerTempTable("person");
		System.out.println("names:    ");
		DataFrame sql=sqlc.sql("select name from person");
		sql.show();
		List<String> df2=df.toJavaRDD().map(s -> s.getString(1)).collect();
		System.out.println("dataframe:"+df2);*/
		
		
		
		
		
	}
	
	
}
