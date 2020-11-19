package com.journaldev.sparkdemo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.AnalysisException;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;

public class JdbcConnect {
public static void main(String[] args) throws AnalysisException {
	SparkSession spark = SparkSession
			  .builder()
			  .appName("Java Spark SQL basic example")
			  .config("master", "local")
			  .master("local")
			  
			  .getOrCreate();
	Map<String, String> options = new HashMap<String, String>();
	
	options.put("driver", "com.mysql.jdbc.Driver");
	options.put("url", "jdbc:mysql://localhost:3306/practise?user=root&password=root");
	options.put("dbtable", "Persons");
     Dataset<Row> df = spark.read().format("jdbc"). options(options).load();
     df.show();
   Person p=new Person();
   p.setId(1);
   p.setName("suraj");
   Person p1=new Person();
   p1.setId(2);
   p1.setName("suraj1");
   Encoder<Person> e=Encoders.bean(Person.class);
   Map<String, String> options1 = new HashMap<String, String>();
	
	options1.put("header", "true");
	options1.put("nullValue", "NA");
   Dataset<Row> course = spark.read().format("csv"). options(options1).load("/home/suraj/Downloads/course.csv");
   Dataset<Person> dset=course.map(a -> {
	 Person person=new Person();
	 person.setId(Integer.parseInt(a.getString(0)));
	 person.setName(a.getString(1));
	 return person;
   }, e);
   dset.show();
   
 //  dset.write().format("jdbc").mode(SaveMode.Append).options(options).save();

}
}
