package com.datastructure.stack;

import java.util.EmptyStackException;

public class StackPract {
	//LIFO structure 
	Node top;
	int length;
	
	public static class Node{
		int data;
		Node next;
		
		public Node(int data){
			this.data=data;
		}
	}

	public StackPract(){
		this.top=null;
		this.length=0;
	}
	public boolean isEmpty(){
		return length==0?true:false;
	}
	
	public void push(int data){
		Node newNode=new Node(data);
		newNode.next=top;
		top=newNode;
		length++;
	}
	
	public int pop(){
		if(isEmpty()){
			throw new EmptyStackException();
		}
		Node temp=top;
		top=temp.next;
		length--;
		return temp.data;
	}
	
	public void print(){
		Node temp=top;
		while(temp!=null){
			System.out.print(temp.data+ "-->");
			temp=temp.next;
		}
	  	System.out.println("null");
	}
	public static void main(String[] args) {
		StackPract s=new StackPract();
		s.push(1);
		s.push(3);
		s.push(5);
		s.print();
		s.pop();
		s.print();
		
	}
}
