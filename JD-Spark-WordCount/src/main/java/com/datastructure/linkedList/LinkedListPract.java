package com.datastructure.linkedList;

import java.util.HashSet;
import java.util.Set;

public class LinkedListPract {

	Node head; // head of list 
	  
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
    
    public static LinkedListPract insert(LinkedListPract list,int data){
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
    public static  void deleteFromlast(LinkedListPract list){
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
    public static LinkedListPract delete(LinkedListPract list,int data){
      Node temp=list.head;
    for(int i=0;i<data-1;i++){
    	temp=temp.next;
    }	
    Node next = temp.next.next; 
    temp.next=next;
		return list;
    	
    }
    public static void printList(LinkedListPract list) 
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
    
    public static String checkProd(LinkedListPract list,int data){
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
    
    public static Integer midList(LinkedListPract list){
    	
    	Node fast=list.head;
    	Node slow=list.head;
    	while(fast!=null && fast.next != null){
    		fast=fast.next.next;
    		slow=slow.next;
    	}
    	
    	
		return slow.data;
    	
    }
    
  public static boolean isPalindrone(LinkedListPract list){
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
    public static void main(String[] args) 
    { 
        /* Start with the empty list. */
    	LinkedListPract list = new LinkedListPract(); 
        list = insert(list, 1); 
        list = insert(list, 2); 
        list = insert(list, 3); 
        list = insert(list, 4); 
        list = insert(list, 3); 
        list = insert(list, 2); 
        list = insert(list, 1); 
     //   list = insert(list, 8); 
        printList(list);
        System.out.println(checkProd(list,20));
       System.out.println(midList(list));
       System.out.println(isPalindrone(list));
        // Print the LinkedList 
       /* printList(list);
        list=delete(list, 3);
        printList(list);*/
    } 
}
