package com.datastructure.queue;


public class QueueImplFromArrays {
static int n=5;
static int[] queue = new int[n];
static int front=-1;
static int rear=-1;

public static void enqueue(int data){
	if(rear == n-1){
		System.out.println("queue is full");
	}else
	if(front==-1 && rear ==-1){
		front=rear=0;
		queue[rear]=data;
	}else{
		rear++;
		queue[rear]=data;	
	}
}
public static void dequeue(){
	if(front==-1 && rear ==-1){
		System.out.println("empty");
	}else if(front==rear){
		front=rear=-1;
	}else{
		front++;
	}
}

public static void main(String[] args) {
	QueueImplFromArrays q=new QueueImplFromArrays();
	q.enqueue(1);
	q.enqueue(2);
	q.enqueue(3);
	q.enqueue(4);
	q.enqueue(5);
	q.dequeue();
	q.dequeue();
	q.dequeue();
	q.dequeue();
	q.dequeue();
	q.enqueue(9);
for(int i=front;i<=rear;i++){
	System.out.print(q.queue[i]);
}
}
}


