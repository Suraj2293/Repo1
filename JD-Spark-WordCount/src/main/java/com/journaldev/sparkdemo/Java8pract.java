package com.journaldev.sparkdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;



public class Java8pract {
	public static void main(String[] args) {
	    long startTime = System.currentTimeMillis();
		String txt = "AABAACAADAABAAABAA"; 
        String pat = "AABA"; 
        
        int n=txt.length();
        int m=pat.length();
        
        for(int i=0;i<n-m;i++){
        boolean flag=true;
        for(int j=0;j<m;j++){
        	if(txt.charAt(i+j)!=pat.charAt(j)){
        		flag=false;
        		break;
        	}
        	
        }
        if(flag){
        	System.out.println(i+"  "+(i+4));
        }
        }
        long endTime = System.currentTimeMillis();

		System.out.println(endTime-startTime  );
	/*	Runnable r=() -> System.out.println("dsdsd");
		r.run();
		List<String> l=new ArrayList<>();
		l.add("suraj");
		l.add("amar");
		l.add("kartik");
		l.add("swaru");
		
		List <String> list=l.stream().filter(s -> s.endsWith("j")).collect(Collectors.toList());

Pattern p=Pattern.compile("ab");
Matcher m=p.matcher("abfgthabkhoyiuababbadsrt");
while(m.find()){
		
	System.out.println(m.start()+"   "+m.end());*/
	
}
	
}


