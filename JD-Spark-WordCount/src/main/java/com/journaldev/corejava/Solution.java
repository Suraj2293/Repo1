package com.journaldev.corejava;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
	 public static class RatingStatisticsCollectorImpl implements RatingStatisticsCollector {
	        Map<String,String> map=new HashMap<>();
	        @Override
	        public void putNewRating(String app, int rating){
	            // YOUR CODE HERE
	        	
	        	if(map.containsKey(app)){
	        	String s[]=map.get(app).split("@");	
	        	int rat=Integer.parseInt(s[0])+rating;
	        	int count=Integer.parseInt(s[1])+1;
	        	String value=String.valueOf(rat)+"@"+String.valueOf(count);
               	map.put(app, value);
	        	}else{
	        	String s=rating+"@"+1;
	            map.put(app, s);
	        	}
	        }

	        @Override
	        public double getAverageRating(String app){
	        	String s[]=map.get(app).split("@");	
	        	double d=Double.parseDouble(s[0])/Double.parseDouble(s[1]);
				return d;
	            // YOUR CODE HERE
	        }

	        @Override
	        public int getRatingsCount(String app){
	        	String s[]=map.get(app).split("@");	
				return Integer.parseInt(s[1]);
	            // YOUR CODE HERE
	        }
	    }

	    ////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

	    public interface RatingStatisticsCollector {
	        // Ratings feed will call this method when new app rating information is received. This is input to your class. ratings is a non negative integer between 0 to 10.
	        public void putNewRating(String app, int rating);

	        // Report the average rating of the app. 
	        public double getAverageRating(String app);

	        // Report the total number of rating for an app.
	        public int getRatingsCount(String app);
	    }

	    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	        int numLines = Integer.parseInt(scanner.nextLine());
	        int currentLine = 0;
	        while (currentLine++ < numLines) {
	            final RatingStatisticsCollector stats = new RatingStatisticsCollectorImpl();
	            final Set<String> apps = new TreeSet<>();

	            String line = scanner.nextLine();
	            String[] inputs = line.split(",");
	            for (int i = 0; i < inputs.length; ++i) {
	                String[] tokens = inputs[i].split(" ");
	                final String app = tokens[0];
	                apps.add(app);
	                final int runs = Integer.parseInt(tokens[1]);

	                stats.putNewRating(app, runs);

	            }

	            for (String app : apps) {
	                System.out.println(
	                        String.format("%s %.2f %d", app, stats.getAverageRating(app), stats.getRatingsCount(app)));
	            }

	        }
	        scanner.close();

	    }   
}
