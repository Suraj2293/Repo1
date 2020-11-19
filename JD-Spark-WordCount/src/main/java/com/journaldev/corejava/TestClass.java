package com.journaldev.corejava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TestClass {
	static int minParkingSpaces(int[][] parkingStartEndTimes) {
		
		final List<List<Integer>> list=new ArrayList<List<Integer>>();
		
		List<Integer> l=null;
		Integer finalCount=0;
		 for (int i = 0; i < parkingStartEndTimes.length; i++) {
			 l=new ArrayList<Integer>();
	            for (int j = 0; j < parkingStartEndTimes[i].length; j++) {
	            	l.add(parkingStartEndTimes[i][j]);
	            }
	            list.add(l);
	            }
		System.out.println(list);
		for(List<Integer> l1:list){
			int count=getCount(l1,list);
			finalCount=finalCount+count;
		}
		
		return finalCount;
        // YOUR CODE HERE

	}
	public static int getCount(List<Integer> list,List<List<Integer>> wholeList){
		int count=0;
		int start=list.get(0);
		int end=list.get(1);
      for(List<Integer> l1:wholeList){
    	  int start1=l1.get(0);
  		  int end1=l1.get(1);
  		if(start!=start1 && end!=end1){
  			for(int i=start1;i<end1;i++){
  				if(i==start || i==end){
  					count++;
  					break;
  				}
  			}
  		}
		}
	return count;
	}
//5,10 0,20 25,40 35,45
	// DO NOT MODIFY ANYTHING BELOW THIS LINE!!

	public static void main(String[] args) throws IOException {
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine().trim());
		int[][] parkingStartEndTimeList = new int[n][2];
		String[] parkingStartEndTimes = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			String[] parkingStartEndTime = parkingStartEndTimes[i].split(",");
			for (int j = 0; j < parkingStartEndTime.length; j++) {
				parkingStartEndTimeList[i][j] = Integer.parseInt(parkingStartEndTime[j]);
			}
		}

		int out = minParkingSpaces(parkingStartEndTimeList);
		System.out.println(out);

		wr.close();
		br.close();*/
		
		Set<String> fruits = new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
			
		});
        // Adding new elements to a TreeSet
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Pineapple");
        fruits.add("Orange");

        System.out.println("Fruits Set : " + fruits);
	}
}
