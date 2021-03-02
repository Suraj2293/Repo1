package com.datastructure.arrays;

import java.util.Arrays;

public class ArraysRotations {
public static void main(String[] args) {
    int a[] = { 1, 3, 5, 7, 9 }; 
    leftRotate(a);
    int b[] = { 1, 3, 5, 7, 9 }; 
    rightRotate(b);
    int c[] = { 1, 3, 5, 7, 9 }; 
    leftRotateWithRotateNumber(c, 2);
    System.out.println();
    int d[] = { 1, 3, 5, 7, 9 ,4,3,5,6,4,5}; 
  //  rightRotateWithRotateNumber(d, 2);
    // reverse string with char arrays
    reverseCharArray("Suraj");
    splitEvenOdd();
    


}
public static void leftRotate(int a[]){
	int temp=a[0];
	for(int i=0;i<=a.length-2;i++){
		a[i]=a[i+1];
	}
	a[a.length-1]=temp;
	System.out.println(Arrays.toString(a));
}

public static void rightRotate(int a[]){
	int temp=a[a.length-1];
	for(int i=a.length-1;i>=1;i--){
		a[i]=a[i-1];
	}
	a[0]=temp;
	System.out.println(Arrays.toString(a));
}

public static void leftRotateWithRotateNumber(int a[],int k){
	int n=a.length;
	int mod=k%n;
	for(int i=0;i<=a.length-1;i++){
		System.out.print(a[(i+mod)%n]+" ");
	}
	
}

public static void rightRotateWithRotateNumber(int a[],int k){
	// 1, 3, 5, 7, 9
	int n=a.length;
	int mod=k%n;
	for(int i=a.length-1;i>=0;i--){
		System.out.print(a[(n-(i+mod))%n]+" ");	
	}
	
}

public static void reverseCharArray(String s){
	// suraj
	char[] c=s.toCharArray();
	int start=0;
	int end=s.length()-1;
	while(start<end){
		char temp=c[end];
		c[end]=c[start];
		c[start]=temp;
		start++;
		end--;
	}
	System.out.println(String.valueOf(c));
}

public static void splitEvenOdd(){
	// suraj
	int a[]={1,3,2,4,5,7,9,6};
	int start=0;
	int end=a.length-1;
	while(start<end){
		if(a[start]%2!=0 && a[end]%2==0){
			int temp=a[end];
			a[end]=a[start];
			a[start]=temp;
			start++;
			end--;
		}else if(a[start]%2!=0 && a[end]%2!=0){
			end--;
		}else if(a[start]%2==0 && a[end]%2==0){
			start++;
		}else if(a[start]%2==0 && a[end]%2!=0){
			start++;
		}
		
	}
	System.out.println(Arrays.toString(a));
}


}
