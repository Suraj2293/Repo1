package com.journaldev.sparkdemo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFlatMapFunction;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.sql.SQLContext;

import scala.Tuple2;

public class WordCounter {

    @SuppressWarnings("resource")
	private static void wordCount() throws InterruptedException {

        SparkConf sparkConf = new SparkConf().setMaster("local[*]").setAppName("JD Word Counter");

        JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);
        @SuppressWarnings("deprecation")
		SQLContext sqlContext = new SQLContext(sparkContext);

        List<String> l=Arrays.asList("abc cdcd dsds","suraj sur sds dd","suraj dsds sds","rutu sds ds");
        JavaRDD<String> lRdd=sparkContext.parallelize(l,4);
        System.out.println(lRdd.partitions().size());
        JavaRDD<String> d=sparkContext.textFile("/home/suraj/Suraj/Testing Files/input.txt");
        JavaRDD<String> d2=sparkContext.textFile("/home/suraj/Suraj/Testing Files/input2.txt");
        JavaRDD<Integer> e=d.map(s -> s.length());
        List<Tuple2<String, String>> l1=Arrays.asList(new Tuple2<String, String>("a","abc"),new Tuple2<String, String>("b","rrr"),new Tuple2<String, String>("a","abc"));
        List<Tuple2<String, String>> l2=Arrays.asList(new Tuple2<String, String>("a","abc"),new Tuple2<String, String>("b","rrr"),new Tuple2<String, String>("a","srd"));
        JavaRDD<Tuple2<String, String>> t=sparkContext.parallelize(l1);
        JavaRDD<Tuple2<String, String>> t1=sparkContext.parallelize(l2);
        //=====================================================================================================
        
        List<String> comp1=Arrays.asList("abc","suraj","suraj","rutu");
        List<String> comp2=Arrays.asList("abc","suraj","may1","rutu");
        JavaRDD<String> comp3=sparkContext.parallelize(comp1);
        JavaRDD<String> comp4=sparkContext.parallelize(comp2);
        
        JavaRDD<String> comp5=comp3.intersection(comp4);
        System.out.println(comp5.collect());
        JavaRDD<String> flatMap1=lRdd.flatMap(x -> {
        	List<String> list=Arrays.asList(x.split(" "));
        	return list.iterator();
        });
        
        
        //=================================================================================================================
        
        JavaPairRDD<String, CallData> pair = d2
        		.mapPartitionsToPair(new PairFlatMapFunction<Iterator<String>, String, CallData>() {
        		private static final long serialVersionUID = 4454545;
        		@Override
        		public Iterator<Tuple2<String, CallData>> call(Iterator<String> arg0) throws Exception {
        		List<Tuple2<String, CallData>> list = new ArrayList<>();
        		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        		while (arg0.hasNext()) {
        		String[] data = arg0.next().split(",");
        		list.add(new Tuple2<String, CallData>(data[0], new CallData(Double.parseDouble(data[1]),
        		Integer.parseInt(data[2]), formatter1.parse(data[3]))));
        		}
        		return list.iterator();
        		}
        		});
        
        		TreeSet<CallData> set = new TreeSet<CallData>();
        		Function2<TreeSet<CallData>, CallData, TreeSet<CallData>> test = new Function2<TreeSet<CallData>, CallData, TreeSet<CallData>>() {
        		private static final long serialVersionUID = 2323;
        		@Override
        		public TreeSet<CallData> call(TreeSet<CallData> arg0, CallData arg1) throws Exception {
        		// TODO Auto-generated method stub
        		arg0.add(arg1);
        		return arg0;
        		}
        		};
        		Function2<TreeSet<CallData>, TreeSet<CallData>, TreeSet<CallData>> test2 = new Function2<TreeSet<CallData>, TreeSet<CallData>, TreeSet<CallData>>() {
        		private static final long serialVersionUID = 9898;
        		@Override
        		public TreeSet<CallData> call(TreeSet<CallData> arg0, TreeSet<CallData> arg1) throws Exception {
        		// TODO Auto-generated method stub
        		arg0.addAll(arg1);
        		return arg0;
        		}
        		};
        		JavaPairRDD<String, TreeSet<CallData>> finalRdd = pair.aggregateByKey(set, test, test2);
        		System.out.println(finalRdd.collect().toString());
        		Double sum = 0d;
        		for (Tuple2<String, TreeSet<CallData>> callData : finalRdd.collect()) {
        		for (CallData calldata : callData._2) {
        		sum = sum + calldata.getOctets();
        		}
        	//	System.out.println("Total Octet for id " + callData._1 + " " + sum);
        		}
        		/*TreeSet<Integer> set1 = new TreeSet<Integer>();
        JavaPairRDD<String, Integer> agg1=d.mapToPair(a -> new Tuple2(a.split(",")[0],a.split(",")[1]));
        Function2<TreeSet<Integer>, Integer, TreeSet<Integer>> seq1=new Function2<TreeSet<Integer>, Integer, TreeSet<Integer>>() {

			@Override
			public TreeSet<Integer> call(TreeSet<Integer> arg0, Integer arg1)
					throws Exception {
				arg0.add(arg1);
				return arg0;
			}
			
			
		};
		   Function2<TreeSet<Integer>, TreeSet<Integer>, TreeSet<Integer>> comp1=new Function2<TreeSet<Integer>, TreeSet<Integer>, TreeSet<Integer>>() {

				@Override
				public TreeSet<Integer> call(TreeSet<Integer> arg0, TreeSet<Integer> arg1)
						throws Exception {
					arg0.addAll(arg1);
					return arg0;
				}};*/
     //  JavaPairRDD<String, TreeSet<Integer>> agg2=agg1.aggregateByKey(set1, seq1, comp1);
     //  System.out.println("agg2:::::"+agg2.collect());
        
       JavaRDD<String> baseRDD=sparkContext.textFile("/home/suraj/Suraj/Testing Files/avg.txt");
       JavaPairRDD<String,Integer> studentRDD = baseRDD.mapToPair( s -> new Tuple2<String,Integer>(s.split(",")[1],Integer.parseInt(s.split(",")[2])));
       JavaPairRDD<String,Avg> avgRDD = studentRDD.aggregateByKey(new Avg(0,0), (v,x) -> new Avg(v.getSum()+x,v.getNum()+1), (v1,v2) -> new Avg(v1.getSum()+v2.getSum(),v1.getNum()+v2.getNum()));

       Map<String,Avg> mapAvg = avgRDD.collectAsMap();

       for(Entry<String,Avg> entry : mapAvg.entrySet()){
           System.out.println("avg::::::::::"+entry.getKey()+"::"+entry.getValue().getAvg());
       }
//============================================================================================================================
       Avg aSet=new Avg(0, 0);
       Function2<Avg,Integer,Avg> seqAvg=new Function2<Avg, Integer,Avg>() {

		@Override
		public Avg call(Avg v, Integer x) throws Exception {
			return new Avg(v.getSum()+x,v.getNum()+1);
		}
	};
	
	 Function2<Avg,Avg,Avg> combAvg=new Function2<Avg, Avg,Avg>() {

		@Override
		public Avg call(Avg v1, Avg v2) throws Exception {
			
			return new Avg(v1.getSum()+v2.getSum(),v1.getNum()+v2.getNum());
		}
		};
		
		JavaPairRDD<String, Avg> avgFinal=studentRDD.aggregateByKey(aSet, seqAvg, combAvg);
		System.out.println("avgFinal"+avgFinal.collect());
		Map<String,Avg> mapAvg1 = avgFinal.collectAsMap();

	       for(Entry<String,Avg> entry : mapAvg1.entrySet()){
	           System.out.println("avg::::::::::"+entry.getKey()+"::"+entry.getValue().getAvg()+"  "+entry.getValue().getNum());
	       }
        //=================================================================================================================
        JavaPairRDD<String, String> c1=d.mapToPair(c11 -> new Tuple2(c11.split(",")[0], c11.split(",")[1]));
        JavaPairRDD<String, String> c2=d2.mapToPair(c22-> new Tuple2(c22.split(",")[0], c22.split(",")[1]));
        System.out.println("cogroup :::::::::::::::::::::::::"+c1.cogroup(c2).collect());
        
        
        JavaPairRDD<String, Iterable<String>> g=d.groupBy(new Function<String, String>() {

			@Override
			public String call(String s) throws Exception {
            return 	s.split(",")[1];			
			}
		});
        System.out.println(g.collect());
        
        for(Tuple2<String, Iterable<String>> s:g.collect()){
        	Iterable<String> i1=s._2;
        	Iterator<String> i2=i1.iterator();
        	while(i2.hasNext()){
        	System.out.println(s._1()+"  "+i2.next());
        	}
        	
        }
        
        JavaPairRDD<String, Double> pairRdd = d.mapToPair(new PairFunction<String, String, Double>() {
        	@Override
        	public Tuple2<String, Double> call(String str) throws Exception {
        	String[] data = str.split(",", -1);
        	return new Tuple2<String, Double>(data[0], Double.parseDouble(data[1]));
        	}
        	});
        
        System.out.println("groupbykey"+pairRdd.groupByKey().collect());
        System.out.println(pairRdd.reduceByKey((a,b) -> a+b).collect());
        
        
        
        JavaRDD<String> a=lRdd.map(new Function<String, String>() {

			@Override
			public String call(String s) throws Exception {
				return s.split(" ")[0];
			}
		});
        
        long count=lRdd.flatMap(a2 -> Arrays.asList(a2.split(" ")).iterator()).filter(a1 -> a1.toString().contains("s")).count();
        JavaRDD<String> c=lRdd.flatMap(new FlatMapFunction<String, String>() {

			@Override
			public Iterator<String> call(String s) throws Exception {
				return Arrays.asList(s.split(" ")).iterator();
			}
		});
        JavaPairRDD<String, Integer> f=c.mapToPair(new PairFunction<String, String, Integer>() {

			@Override
			public Tuple2<String, Integer> call(String s) throws Exception {
				
				return new Tuple2<String, Integer>(s.split(" ")[0],1);
			}
		});
        
        JavaPairRDD<String, Integer> counts=f.reduceByKey((x,y) -> x+y);
        JavaRDD<String> b=lRdd.map(s -> s.split(" ")[1]);
     //   Thread.sleep(10000000);
        	

       /* JavaRDD<String> inputFile = sparkContext.textFile("/home/suraj/Suraj/Testing Files/input.txt");

        JavaRDD<String> wordsFromFile = inputFile.flatMap(content -> Arrays.asList(content.split(" ")));

        JavaPairRDD countData = wordsFromFile.mapToPair(t -> new Tuple2(t, 1)).reduceByKey((x, y) -> (int) x + (int) y);

        System.out.println(countData.collect());*/
    }

    public static void main(String[] args) throws InterruptedException {
        wordCount();
    }
}
