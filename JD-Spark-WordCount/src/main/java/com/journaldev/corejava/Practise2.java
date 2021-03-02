package com.journaldev.corejava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class Practise2 {
public static int next(int n){
		return n==1?0:1;
	}
public static void main(String[] args) {
	
		List<String> loans = new CopyOnWriteArrayList<>();	
		loans.add("personal loan");
		loans.add("home loan");
		loans.add("auto loan");
		loans.add("credit line loan");
		loans.add("mortgage loan");
		loans.add("gold loan");
		loans.add("A");
	//	System.out.println(loans);
		for (String loan : loans) {
		//	System.out.print(loan+" ");
			if (loan.equals("A")) {
				
				loans.remove(loan);
				//loans.add("abd");
	
			}
			loans.add(loans.indexOf("auto loan"),"abd");
		}
		System.out.println(loans);
		
		Iterator<String> itr = loans.iterator();
		while (itr.hasNext()) {
			String loan = itr.next();
			System.out.print(loan+" ");
			if (loan.equals("personal loan")) {
				itr.remove();
			}
		}
		System.out.println(loans);
		
		List<String> l = new ArrayList<>(); 
        l.add("A"); 
        l.add("B"); 
        l.add("C"); 
        System.out.println(l);
     for(String list:l){
    		if (list.equals("B")) 
    	    { 
    	        l.remove(list);
    	    } 
    	}
     System.out.println(l);
    /* Iterator<String> itr = l.listIterator(); 
       
     while (itr.hasNext())  
     { 
         String s = (String)itr.next(); 
           
         if (s.equals("B")) 
         { 
             itr.remove(); 
         } 
     } */
 } 


	/*int a[]={1,0,1,0,1,1};
    int count=0;
    int expectedNumber=0;
	for(int i=0;i<a.length;i++){
		if(i==0){
			expectedNumber=next(a[i]);
			continue;
		}
		if(a[i]!=expectedNumber){
			count++;
		}
		expectedNumber=next(a[i]);
	}
	System.out.println(count);*/
	
	/*String s="abba";
	int n=s.length();
	int count=0;
	boolean flag=true;
	for(int i=0;i<n-1;i++){
		if(s.charAt(i)=='b' && i==0){
			flag=false;
			break;
		}
		if(s.charAt(i)=='a'){
			if(count>0){
				flag=false;
			}
		}else if(s.charAt(i)=='b'){ 
		count++;	
		}
		
	}
	
	System.out.println(flag);*/
	/*int n=670;
	String num=""+n;
	int l=num.length();
	int digit=5;
	int pos=0;
	String s1="";
	for(int i=0;i<l;i++){
		if(num.charAt(i)=='-'){
			continue;
		}
		if(Integer.parseInt(String.valueOf(num.charAt(i)))<digit){
			pos=i;
			s1=s1+""+digit;
			s1=s1+num.charAt(i);
			
		}else{
			s1=s1+num.charAt(i);
		}
	}
	System.out.println(Integer.parseInt(s1));*/
}


