package com.datastructure.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackPractArrays {
	int arraySize=5;
int a[]=new int[arraySize];
int top=-1;

public boolean isEmpty(){
	return top==-1?true:false;
}

public void push(int data){
	if(top==arraySize-1){
		System.out.println("overflow");
	}
	top++;
	a[top]=data;
	
}
public void pop(){
	if(isEmpty()){
		throw new EmptyStackException();
	}
	System.out.println("pop data = "+a[top]);
	top--;
}

public void peek(){
	if(isEmpty()){
		throw new EmptyStackException();
	}
	System.out.println("peek element = "+a[top]);
}
public void print(){
	for(int i=top;i>=0;i--){
		System.out.print(a[i]+" ");
		
	}
	System.out.println();
}
public static void main(String[] args) {
	StackPractArrays s=new StackPractArrays();
	s.push(1);
	s.push(4);
	s.print();
	s.pop();
	s.print();
}
}
