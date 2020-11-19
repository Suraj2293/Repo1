package com.datastructure.queue;


public class QueueImplFromLinkedList {

	Node head; // head of list 
	static Node front=null;
	static Node rear=null;
    // Linked list Node. 
    // This inner class is made static 
    // so that main() can access it 
	
    static class Node { 
  
        int data; 
        Node next; 
  
        // Constructor 
        Node(int d) 
        { 
            data = d; 
            next = null; 
        } 
    } 
    
    public static void  enqueue(int data){ 
    	Node newNode=new Node(data);
    	newNode.next=null;
    	if(front==null && rear==null){
    		front=rear=newNode;
    	}else{
    		rear.next=newNode;
    		rear=newNode;
    	}	
    }
    
    public static void dequeue(){
    	Node temp=front;
    	if(front==null && rear==null){
    		System.out.println("queue is empty");
    	}else if(front.next==null && rear.next==null){
    		front=rear=null;
    		temp=null;
    	}
    	else{
    		front=front.next;	
    		temp=null;
    	}
    }
    public static void printList() 
    { 
    	if(front==null && rear==null){
    		System.out.println("queue is empty");
    	}
    	else {
    		Node temp=front;
    		while(temp!=null){
    			System.out.println(temp.data);
    			temp=temp.next;
    		}
    	}
    }
    
 
    public static void main(String[] args) 
    { 
        /* Start with the empty list. */
        enqueue(1); 
        enqueue(2); 
        enqueue(3);   
        dequeue();
        dequeue();
        dequeue();
        enqueue(4);
    printList();
    } 
}
