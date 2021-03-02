package com.datastructure.linkedList;



import java.util.HashSet;
import java.util.Set;


public class LinkedListPractAll {

	Node head; // head of list 
	int length; 
	
	public LinkedListPractAll(){
		this.head=null;
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
    
    public void  insertAtLast(int data){
    	Node newNode=new Node(data);
    	
    	if(head==null){
    		head=newNode;
    	}else{
    		Node last=head;
    		while(last.next!=null){
    			last=last.next;
    		}
    		last.next=newNode;	
    	}
    	length++;
    	
    }
    
    public void  insertAtFirst(int data){
    	Node newNode=new Node(data);
   	 if(head==null){
   		 head=newNode;
   	 }
   	 else{
   		  Node temp = head;  
          head = newNode;  
          head.next = temp;  
   	 }
   	 length++;
    }
    
    public void insertAtGivenPos(int data,int pos){
    	Node newNode=new Node(data);
    	Node current=head;
    	Node prev=head;
    	if(isEmpty()){
    		return;
    	}
    	for(int i=0;i<pos-1;i++){
    		prev=current;
    		current=current.next;
    	}
    	prev.next=newNode;
    	newNode.next=current;
    	length++;
    }
    
    public  void deleteFromlast(){
   	 if(head==null){
   		 System.out.println("Queue is empty");
   	 }else {
   		 Node last=head;
   		 Node prev=head;
   		 if(last.next==null){
   			 head=null;
   			 return;
   		 }
   		 while(last.next!=null){
   			 prev=last;
   			 last=last.next;
   		 }
   		 prev.next=null;
   	 }
   	 length--;
    }
    public void delete(int data){
      Node temp=head;
    for(int i=0;i<data-1;i++){
    	temp=temp.next;
    }	
    Node next = temp.next.next; 
    temp.next=next;
		length--;
    	
    }
    public void deleteFromFirst(){
    	if(isEmpty()){
    		System.out.println("list is empty");
    		return;
    	}
    	Node temp=head;
    	head=head.next;
    	temp.next=null;
    	temp=null;
    }
    
    public void deleteFromGivenPos(int pos){
    	Node current=head;
    	Node prev=head;
    	if(isEmpty()){
    		return;
    	}
    	for(int i=0;i<pos-1;i++){
    		prev=current;
    		current=current.next;
    	}
    	prev.next=current.next;
    	current.next=null;
    	current=null;
    	
    }
    public  void printList() 
    { 
        Node currNode = head; 
        System.out.print("LinkedList: "); 
        while (currNode != null) { 
            System.out.print(currNode.data + " "); 
            currNode = currNode.next; 
        } 
        System.out.println();
    }
    
    public static String checkProd(LinkedListPractAll list,int data){
    		Node last=list.head;
    		Set<Integer> s=new HashSet<>();
    		while(last.next!=null){
    			int temp=data/last.data;
    			if(s.contains(temp)){
    				return "prod"+last.data+" "+temp;
    			}
    			s.add(last.data);
    			last=last.next;
    		}
    	
		return "not found";
    	
    }
    
    public static Integer midList(LinkedListPractAll list){
    	
    	Node fast=list.head;
    	Node slow=list.head;
    	while(fast!=null && fast.next != null){
    		fast=fast.next.next;
    		slow=slow.next;
    	}
    	
    	
		return slow.data;
    	
    }
    
  public static boolean isPalindrone(LinkedListPractAll list){
	  Node last=list.head;
	  StringBuffer s=new StringBuffer("");
	  while(last!=null){
		  
		  s.append(last.data);
		  last=last.next;
	  }
		System.out.println(s);
		System.out.println(s.reverse());
		if(s.toString().equals(s.reverse().toString())){
			return true;
		}
		else
		{
			return false;
		}	
	  
  }
  
  public void revereselist(){
	  if(isEmpty()){
		  System.out.println("list is empty");
	  }
	  Node prev=null;
	  Node nextNode=head;
	  Node currentNode=head;
	  while(nextNode!=null){
		  nextNode=nextNode.next;
		  currentNode.next=prev;
		  prev=currentNode;
		  currentNode=nextNode;
	  }
	  head=prev;
  }
  
    public static void main(String[] args) 
    { 
    	LinkedListPractAll list = new LinkedListPractAll(); 
    	list.insertAtFirst(1);
    	list.insertAtLast(2);
    	list.insertAtLast(3);
    	list.insertAtLast(4);
    	list.printList();
    	list.insertAtGivenPos(8, 3);
    //	list.deleteFromFirst();
    	list.deleteFromGivenPos(3);
    	list.printList();
    	list.revereselist();
    	list.printList();
      
    } 
}
