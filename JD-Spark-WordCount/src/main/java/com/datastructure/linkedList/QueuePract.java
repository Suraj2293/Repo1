package com.datastructure.linkedList;



public class QueuePract {
Node head;

 static class Node{
	int data;
	Node next;
	Node(int d){
		data=d;
		next=null;
	}
	
	
}
 public static QueuePract  insert(QueuePract list,int data){
	 Node newNode=new Node(data);
	 newNode.next=null;
	 if(list.head==null){
		 list.head=newNode;
	 }else{
		 Node last=list.head;
		 while(last.next!=null){
			 last=last.next;
			 
		 }
		 last.next=newNode;
	 }
	 return list;
 }
 
 public static  void deleteFromlast(QueuePract list){
	 if(list.head==null){
		 System.out.println("Queue is empty");
	 }else {
		 Node last=list.head;
		 Node prev=list.head;
		 if(last.next==null){
			 list.head=null;
			 return;
		 }
		 while(last.next!=null){
			 prev=last;
			 last=last.next;
		 }
		 prev.next=null;
	 }
 }
 public static QueuePract insertAtFirst(QueuePract list,int data){
	 
	 if(list.head==null){
		 Node newNode=new Node(data);
		 newNode.next=null;
		 list.head=newNode;
	 }
	 else{
		 Node newNode=new Node(data);
		  Node temp = list.head;  
          list.head = newNode;  
          list.head.next = temp;
	 }
	 
	 return list;
 }
 
 public static QueuePract deleteFromLast(QueuePract list,int pos){
	 
	 
		  Node last = list.head;
		  int count=0;
		  while(last.next.next!=null){
			  last=last.next;
			  count++;
		  }
		 
		 last.next=null;
	 return list;
 }
 
 public static void printList(QueuePract list) 
 { 
     Node currNode = list.head; 

     System.out.print("LinkedList: "); 

     // Traverse through the LinkedList 
     while (currNode != null) { 
         // Print the data at current node 
         System.out.print(currNode.data + " "); 

         // Go to next node 
         currNode = currNode.next; 
     } 
 }
 public static void main(String[] args) 
 { 
     /* Start with the empty list. */
	 QueuePract list = new QueuePract(); 
	 insert(list, 3);
	 insert(list, 4);
	 insert(list, 5);
	 insert(list, 6);
	 deleteFromlast(list);
	 //insertAtFirst(list, 2);
	// insertAtFirst(list, 1);
	// deleteFromLast(list,3);
	 printList(list);
    
 } 
}
