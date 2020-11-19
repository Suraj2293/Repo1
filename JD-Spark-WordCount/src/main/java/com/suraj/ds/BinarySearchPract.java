package com.suraj.ds;

import java.util.Arrays;

public class BinarySearchPract {
	public static void main(String[] args) {
		int a[]={ 2, 3, 1, 10, 40,33,9 }; 
	//	int result=binarySearch(a, 0, a.length-1, 10);
		bubblesort(a);	
	int	b[]={64,25,12,22,11};
		selectionSort(b);
		int arr[] = { 12, 11, 13, 5, 6 }; 
		insertionSort(arr);
	}
public static int binarySearch(int a[],int l,int r,int x){
	if(l<=r){
		int mid=(l+r)/2;
		if(a[mid]==x){
			return mid;
		}
		if(a[mid]>x){
			return binarySearch(a, l, mid-1, x);
		}else{
			return binarySearch(a, mid+1,r , x);
		}
	}
	
	return -1;
	
	
}

public static void bubblesort(int a[]){
	int n=a.length;
	for(int i=0;i<n-1;i++){
		for(int j=0;j<n-i-1;j++){
			if(a[j]<a[j+1]){
				int temp=a[j];
				a[j]=a[j+1];
				a[j+1]=temp;
			}
		}
	}
	System.out.println(Arrays.toString(a));
}

public static void selectionSort(int a[]){
	//{64,25,12,22,11};  
	int n=a.length;
	for(int i=0;i<n-1;i++){
		int min=i;
		for(int j=i+1;j<n;j++){
			if(a[j] <a[min]){
				min=j;
			}
		}
		int temp=a[min];
		a[min]=a[i];
		a[i]=temp;
		
	}
	System.out.println(Arrays.toString(a));
	
}

public static void insertionSort(int a[]){
	//nt arr[] = { 12, 11, 13, 5, 6 }; 
	int n=a.length;
	for(int i=1;i<n;i++){
		int key=a[i];
		int j=i-1;
		while(j>=0 && key< a[j]){
			a[j+1]=a[j];
			j=j-1;
		}
		a[j+1]=key;
	}
	System.out.println(Arrays.toString(a));
	
	
}
}
