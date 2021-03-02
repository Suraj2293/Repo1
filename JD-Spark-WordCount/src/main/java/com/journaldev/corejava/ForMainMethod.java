package com.journaldev.corejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class ForMainMethod {

	public static void main(String[] args) {
		new ForMainMethod().a();
		Ass a=new B();
		Map<City,String> map=new HashMap<City, String>();
		City c1=new City(1, "city1");
		City c2=new City(2, "city2");
		map.put(c1, "1");
		map.put(c2, "2");
		System.out.println(map);
		System.out.println(map.get(c1));
		c1=null;
		System.out.println(map.get(c1));
		
		int arr1[] = {1, 2, 3, 4, 5, 6};
	int arr2[] = {1, 2, 4,9} ;
	List <Integer> l1=Arrays.asList(1, 2, 3, 4, 5, 6);
	List <Integer> l2=Arrays.asList(1, 2, 4,9);
	Long a2=Arrays.stream(arr2).filter(a1 -> (!Arrays.asList(arr1).contains(a1))).count();
	Long a3=l2.stream().filter(a4 -> !l1.contains(a4)).count();
	System.out.println("count : "+a2);
	System.out.println("count : "+a3);
	System.out.println(l1.contains(12));
	
	int arr[] = {1, 2, 1, 3, 4, 2, 3};
	int k=4;
	int n=arr.length;
	Set<Integer> s=null;
	for(int i=0;i<=n-k;i++){
		s=new HashSet<>();
		for(int j=i;j<=i+k-1;j++){
			s.add(arr[j]);
		}
		System.out.println(s.size());
		s.clear();
	}
		List<Integer> list3=Arrays.asList(1, 2, 1, 3, 4, 2, 3).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(list3);
		/*Scanner s=new Scanner(System.in);
		String s1=s.next();
		int i=s.nextInt();
		
		System.out.println(s1 +i);*/
		
		/*int a[]={12, 21, 31, 9, 5, 8} ;
		int n=a.length;
		
		for(int i=0;i<=n-2;i++){
			int sum=0;
			int start=i;
		 
		while(sum<45 && start<=n-1)	{
			sum=sum+a[start];
		    start++;
		}
		
		if(sum==45){
			 for(int j=i;j<start;j++){
				 System.out.println(j);
			 }
		 }
		*/
		
		/*String s="javaconceptoftheday";
		char[] c=s.toCharArray();
		int n=c.length;
		Map<Character,Integer> m=new LinkedHashMap<>();
		String longString=null;
		int l=0;
		for(int i=0;i<n;i++){
			if(!m.containsKey(c[i])){
				m.put(c[i], i);
			}
			else
			{
				i=m.get(c[i]);
				m.clear();
			}
			if(m.size()>l){
				l=m.size();
				longString=m.keySet().toString();
			}
		}
		System.out.println(longString);
		System.out.println(l);*/
/*	int a[]={12, 9, 21, 17, 33, 7};
	int temp=a[0];
	for(int i=0;i<a.length-1;i++){
		
		a[i]=a[i+1];
		
	}
	a[a.length-1]=temp;
	System.out.println(Arrays.toString(a));*/
	
	
	}
	public void a(){
		int a[]={3, 4, 2, 3, 16, 3, 15, 16, 15, 15, 16, 2, 3};
		Map<Integer,Integer> map=new HashMap<Integer, Integer>();
		for(int i=0;i<a.length;i++){
			map.put(a[i], map.get(a[i])==null?1:map.get(a[i])+1);
		}
		System.out.println(map);
		
		//sort by value or key
		List<Entry<Integer,Integer>> list=new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());	
		map.entrySet().iterator();
		map.keySet().iterator();
	
		Comparator<Entry<Integer,Integer>> comp=new Comparator<Map.Entry<Integer,Integer>>() {
			
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o2.getValue()-o1.getValue();
			}
		};
		
		Comparator<Entry<Integer,Person1>> c=new Comparator<Entry<Integer,Person1>>() {
			
			@Override
			public int compare(Entry<Integer, Person1> o1, Entry<Integer, Person1> o2) {
				return o2.getValue().age-o1.getValue().age;
			}
		};
		
		Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>() {

			//sort by values
			/*@Override
			public int compare(Entry<Integer, Integer> o1,
					Entry<Integer, Integer> o2) {
				return o2.getValue()-o1.getValue();
			}

		});*/
		
			//sort bu=y keys
		@Override
		public int compare(Entry<Integer, Integer> o1,
				Entry<Integer, Integer> o2) {
			return o2.getKey()-o1.getKey();
		}

	});
		System.out.println(list);

		}
	}

class Ass{
	Ass(){
		System.out.println("constructor A");
		
	}
		
	static{
		System.out.println("static a");
	}
	{
		System.out.println("IIA");
	}
}
class B extends Ass{
	B(){
	System.out.println("constructor B");	
	}
	static{
		System.out.println("static B");
	}
	{
		System.out.println("IIB");
	}
}






