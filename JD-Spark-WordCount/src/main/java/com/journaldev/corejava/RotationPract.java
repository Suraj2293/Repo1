package com.journaldev.corejava;

import java.util.Arrays;

public class RotationPract {
public static void main(String[] args) {
	rearrangeZeroes();
	rearrangePositiveNegative();
	}
public static void rearrangeZeroes(){
	int a[]={1,3,0,5,7,0,7,0,0,3};
	int r[]=new int[a.length];
	
	int start=0;
	int end=a.length-1;
	for(int i=0;i<=a.length-1;i++){
		if(a[i]!=0){
			r[start]=a[i];
			start++;
		}else{
			r[end]=a[i];
			end--;
	}
	}
	System.out.println(Arrays.toString(a));
	System.out.println(Arrays.toString(r));
}
public static void rearrangePositiveNegative(){
	int a[]={-1, 2, -3, 4, 5, 6, -7, 8, 9};
	int r[]=new int[a.length];
	
	int start=0;
	int end=a.length-1;
	for(int i=0;i<=a.length-1;i++){
		if(a[i]<0){
			r[start]=a[i];
			start++;
		}else{
			r[end]=a[i];
			end--;
	}
	}
	System.out.println(Arrays.toString(a));
	System.out.println(Arrays.toString(r));
}
}
