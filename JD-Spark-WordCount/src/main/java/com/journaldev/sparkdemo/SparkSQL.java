package com.journaldev.sparkdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.AnalysisException;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import scala.Tuple2;


public class SparkSQL {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws AnalysisException {
		SparkConf sconf=new SparkConf().setMaster("local").setAppName("sparkSql");
JavaSparkContext sc=new JavaSparkContext(sconf);
SQLContext sql=new SQLContext(sc);
/*Dataset<Row> d=sql.read().json("/home/suraj/Suraj/Testing Files/input1.json");
JavaRDD<Person> p=sc.textFile("/home/suraj/Suraj/Testing Files/input.txt").map(new Function<String, Person>() {

	@Override
	public Person call(String s) throws Exception {
		Person p=new Person();
		p.setId(Integer.parseInt(s.split(",")[0]));
		p.setName(s.split(",")[1]);
		return p;
	}
});*/
JavaRDD<String>  jrdd=sc.parallelize(Arrays.asList("one","two","three","two","three","three"));
JavaPairRDD<String, Integer>jprdd=jrdd.mapToPair(a -> new Tuple2<String,Integer>(a,1));
System.out.println(jprdd.collect());
System.out.println(jprdd.groupByKey().map(t -> t._2).collect());

Person p1=new Person();
p1.setId(1);
//Dataset<Row> d1=sql.createDataFrame(p, Person.class);
//d1.select("name").show();
Encoder<Person> e=Encoders.bean(Person.class);
Dataset<Person> dset=sql.createDataset(Arrays.asList(p1), e);
//dset.show();


Encoder<Integer> i=Encoders.INT();
Dataset<Integer> dint=sql.createDataset(Arrays.asList(1,2,3,4), i);
Dataset<Integer> dint1=dint.map(a -> a*2, i);
//dint1.show();
//create dataframe with programatic way
/*JavaRDD<String> a=sc.textFile("/home/suraj/Suraj/Testing Files/input.txt");
String schemaString="id name";
List<StructField> l=new ArrayList<StructField>();
for(String s:schemaString.split(" ")){
	l.add(DataTypes.createStructField(s, DataTypes.StringType, true));
}
StructType schema=DataTypes.createStructType(l);
JavaRDD<Row> j=a.map(new Function<String, Row>() {

	@Override
	public Row call(String s) throws Exception {
	return RowFactory.create(s.split(",")[0],s.split(",")[1]);	
	}
});
Dataset<Row> df=sql.createDataFrame(j, schema);
df.createGlobalTempView("t");
Dataset<Row> df1=sql.sql("select * from t");


JavaRDD<String> j1=df1.javaRDD().map(r -> r.getString(1));
System.out.println(j1.collect());
*/

	}

}
