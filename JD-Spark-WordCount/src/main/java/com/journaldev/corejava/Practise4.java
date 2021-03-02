package com.journaldev.corejava;

public class Practise4 {
	public static int next(int i){
		return i==0?1:0;
	}
public static void main(String[] args) {
	int a[]={0,0,1,0,1,1,1};
    int count=0;
    int expectedNumber=0;
	/*for(int i=0;i<a.length;i++){
		if(i==0){
			expectedNumber=next(a[i]);
			continue;
		}
		if(a[i]!=expectedNumber){
			count++;
		}
		expectedNumber=next(a[i]);
	}
	*/
    int even=a[0];
    int odd=even==0?1:0;
    for(int i=0;i<a.length;i=i+2){
    	if(a[i]!=even && i!=0){
    		count++;
    	}
    }
    for(int i=1;i<a.length;i=i+2){
    	if(a[i]!=odd){
    		count++;
    	}
    }
    System.out.println(count);
}
}
