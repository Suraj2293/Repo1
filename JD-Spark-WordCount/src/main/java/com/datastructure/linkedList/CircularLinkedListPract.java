package com.datastructure.linkedList;


public class CircularLinkedListPract {
	Node head; // head of list 
	Node tail;  //last node of the list pointing the head
	int length; 
	
	public CircularLinkedListPract(){
		this.head=null;
		this.tail=null;
		this.length=0;
	}
	
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
    public boolean isEmpty(){
    	return length==0?true:false;
    }
    
    public void createCircularLinkedList(int data){
    	Node newNode=new Node(data);
    	if(head==null){
    		head=tail=newNode;
    	}else{
    		tail.next=newNode;
    		tail=newNode;
    		
    	}
    	tail.next=head;
    	length++;
    }
    
    public void printLst(){
    	Node temp=head;
    	if(head==null){
    		System.out.println("list is empty");
    	}
    	while(temp.next!=head){
    		System.out.print(temp.data+" ");
    		temp=temp.next;
    		
    	}
    	System.out.println(temp.data);
    }
    public void insertAtBeginningOfCircularList(int data){
    	Node newNode=new Node(data);
    	if(head==null){
    		head=tail=newNode;
    		tail.next=head;
    	}else{
    		tail.next=newNode;
    		newNode.next=head;
    		head=newNode;
    	}
    	length++;
    }
    
    public void deleteFromBegining(){
    	if(head==null){
    		System.out.println("list is empty");
    	}else if(head==tail){
    		head=tail=null;
    	}else{
    		tail.next=head.next;
    		head=head.next;
    	}
    	length--;
    }
    
    public void deleteFromLast(){
    	if(head==null){
    		System.out.println("list is empty");
    	}else if(head==tail){
    		head=tail=null;
    	}else{
    		Node current=head;
    		Node prev=null;
    		while(current.next!=head){
    			prev=current;
    			current=current.next;
    		}
    		prev.next=head;
    		tail=prev;
    		current=null;
    		
    	}
    	length--;
    }
    
    public void deleteFromPos(int pos){
    	if(length<pos){
    		System.out.println("invalid position");
    	}
    	if(head==null){
    		System.out.println("List is empty");
    	}else if(head==tail){
    		head=tail=null;
    	}else {
    		Node prev=null;
    		Node current=head;
    		for(int i=0;i<pos-1;i++){
        		prev=current;
        		current=current.next;
        	}
    		prev.next=current.next;
        	current.next=null;
        	current=null;
    	}
    }
    
    public static void main(String[] args) {
		CircularLinkedListPract c=new CircularLinkedListPract();
		c.createCircularLinkedList(1);
		c.createCircularLinkedList(2);
		c.createCircularLinkedList(3);
		c.createCircularLinkedList(4);
		c.printLst();
		c.insertAtBeginningOfCircularList(7);
		c.printLst();
		c.deleteFromBegining();
		c.printLst();
		c.deleteFromLast();
		c.printLst();
		System.out.println(c.tail.data);
		System.out.println(c.tail.next.data);
	}
}

