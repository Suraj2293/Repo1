package com.journaldev.sparkdemo;

import static org.apache.spark.sql.functions.avg;
import static org.apache.spark.sql.functions.count;
import static org.apache.spark.sql.functions.max;
import static org.apache.spark.sql.functions.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.AnalysisException;
import org.apache.spark.sql.Dataset;
//import org.apache.spark.sql.functions;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;

import scala.Serializable;

public class DbConnect implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws AnalysisException {
		SparkConf sconf=new SparkConf().setMaster("local").setAppName("sparkSql");
		JavaSparkContext sc=new JavaSparkContext(sconf);
		SQLContext sql=new SQLContext(sc);
		
		Map<String, String> options = new HashMap<String, String>();
		
		options.put("driver", "com.mysql.jdbc.Driver");
		options.put("url", "jdbc:mysql://localhost:3306/practise?user=root&password=root");
		options.put("dbtable", "Persons");
		
Map<String, String> options1 = new HashMap<String, String>();
		
		options1.put("header", "true");
		options1.put("nullValue", "NA");
	//	options1.put("inferSchema", "true");

	//	Dataset<Row> df = sql.read().format("jdbc"). options(options).load();
		Dataset<Row> course = sql.read().format("csv"). options(options1).load("/home/suraj/Downloads/course.csv");
		Dataset<Row> users = sql.read().format("csv"). options(options1).load("/home/suraj/Downloads/users.csv");
		Dataset<Row> enrollment = sql.read().format("csv"). options(options1).load("/home/suraj/Downloads/enrollment.csv");
		Dataset<Row> airport = sql.read().format("csv"). options(options1).load("/home/suraj/Downloads/Airport.csv");
		Dataset<Row> airport_state = sql.read().format("csv"). options(options1).load("/home/suraj/Downloads/Airport_state.csv");
		course.show();
		users.show();
		enrollment.show();
		
		/*Dataset<Row> r1=course.join(enrollment,course.col("cid").equalTo(enrollment.col("cid"))).select(course.col("cid"),course.col("cname"),enrollment.col("score"),
						enrollment.col("e_status"),enrollment.col("cid").alias("e_cid"));*/
		Dataset<Row> r1=course.join(enrollment,course.col("cid").equalTo(enrollment.col("cid"))).groupBy(course.col("cid")).agg(avg(enrollment.col("score")), max(enrollment.col("score")),
				count(when(enrollment.col("e_status").equalTo("inactive"),1).alias("inactive users")));
		r1.show();
		/*r1.createGlobalTempView("Suraj");
		Dataset<Row> abc=sql.sql("select cid ,max(score),count(cid) from global_temp.Suraj group by cid order by cid desc").toDF();
		abc.show();*/
		
		//r1.groupBy(course.col("cid")).count().orderBy("count").toDF().show();
		/*Encoder<Enrollment> e=null;
		Dataset<Enrollment> p=null;
		e=Encoders.bean(Enrollment.class);
		p=r1.as(e);
        JavaRDD<Enrollment> erdd=p.toJavaRDD();
		System.out.println(erdd.map(a -> a.getScore()).distinct().collect());*/
		
	/*	course.join(enrollment, enrollment.col("cid").equalTo(course.col("cid"))).select(course.col("cname"),
				enrollment.col("e_status"),enrollment.col("e_status"));*/
		
		//course.select("cid","cname").groupBy("cname").count().show();
	/*	Dataset<Row> air=airport.join(airport_state,airport.col("City").equalTo(airport_state.col("City"))).select(airport.col("Id"),airport.col("Name"),airport_state.col("State")).groupBy(airport_state.col("State")).count();
		air.show();
		course = course.withColumn("label", course.col("cname"));

		enrollment.repartition(enrollment.col("uid"));
		Dataset<Row> d1=enrollment.repartition(enrollment.col("uid"));
		enrollment.write().partitionBy("uid").save("/home/suraj/Downloads/course1.json");*/
	//	Dataset<Row> d2=sql.sql("select * from person");
		
		//d2.show();
		/*course.join(enrollment, enrollment.col("cid").equalTo(course.col("cid"))).
		join(users, users.col("uid").equalTo(enrollment.col("uid"))).select(course.col("cname"),
				enrollment.col("e_status"),users.col("u_status")).filter("e_status='active'").groupBy(course.col("cname")).count().show();
		
		
		course.javaRDD().map(r->r.get(1)).collect();*/
		
		
		
	/*	df1.write().format("json").save("/home/suraj/Downloads/csv1.json");
		JavaRDD<Row> row=df1.javaRDD();
		JavaRDD<String> name=row.map(s -> s.getString(1));
		System.out.println(name.collect());
		
		JavaRDD<Person> p=sc.textFile("/home/suraj/Suraj/Testing Files/input.txt").map(new Function<String, Person>() {

			@Override
			public Person call(String s) throws Exception {
				Person p=new Person();
				p.setId(Integer.parseInt(s.split(",")[0]));
				p.setName(s.split(",")[1]);
				return p;
			}
		});
		Dataset<Row> d1=sql.createDataFrame(p, Person.class);
		//d1.write().format("jdbc").mode(SaveMode.Ignore).options(options).save();
		UDF1<String, String> abc=new UDF1<String, String>() {
			
			@Override
			public String call(String s) throws Exception {
				return s.toUpperCase();
			}
		};
	//	sql.udf().register("abc", (UserDefinedAggregateFunction) abc);
		sql.udf().register("abc",  abc,DataTypes.StringType);
		
		d1.withColumn("name1",d1.col("name"));*/
		
		
		Encoder<Integer> i=Encoders.INT();
		Dataset<Integer> id=sql.createDataset(Arrays.asList(1,2,3,4,5), i);
		id.show();
		Dataset<Integer> id1=id.map(a -> a*2, i);
		id1.show();
	}


}
