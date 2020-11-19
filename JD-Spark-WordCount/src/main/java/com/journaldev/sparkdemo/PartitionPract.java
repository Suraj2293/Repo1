package com.journaldev.sparkdemo;

import java.util.Arrays;
import java.util.Iterator;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;

public class PartitionPract {
public static void main(String[] args) throws InterruptedException {
	SparkConf sc=new SparkConf().setMaster("local[*]").setAppName("spark");
	JavaSparkContext jsc=new JavaSparkContext(sc);
	JavaRDD<Integer> s=jsc.parallelize(Arrays.asList(1,2,6,8,3,4,3,4,8,6,0,4),2);
	System.out.println(s.partitions().size());
	
	s.map(a -> a.toString().length()).count();
	Thread.sleep(100000);
	
	//JavaRDD<Integer> s1=s.repartition(2);
	//System.out.println(s.partitions().size());
	//System.out.println(s1.partitions().size());
	/*s1.foreachPartition(new VoidFunction<Iterator<Integer>>(){

		@Override
		public void call(Iterator<Integer> i) throws Exception {
while(i.hasNext()){
	System.out.println(i.next());
	
}
		System.out.println("next element::::::::::");	
	}
		
	});*/
Function2<Integer, Iterator<Integer>, Iterator<Integer>> f2=new Function2<Integer, Iterator<Integer>, Iterator<Integer>>() {

	@Override
	public Iterator<Integer> call(Integer arg0, Iterator<Integer> arg1)
			throws Exception {
		Iterator<Integer> it;
		it=arg1;
		return arg1;
	}
};


//JavaRDD<Integer> a=s1.mapPartitionsWithIndex(f2, true);
//System.out.println(a.collect());
}
}
