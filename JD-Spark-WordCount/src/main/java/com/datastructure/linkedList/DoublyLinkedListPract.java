package com.datastructure.linkedList;

public class DoublyLinkedListPract {
	private Node head;
	private Node tail;
	private int length;

	private static class Node{
		private int data;
		private Node next;
		private Node previous;
		
		public Node(int data){
			this.data=data;
		}
	}
	public DoublyLinkedListPract(){
		this.head=null;
		this.tail=null;
		this.length=0;
	}
    public boolean isEmptyList(){
    	if(length==0)
    		return true;
    	else
    		return false;
    }
    public Integer listLength(){
    	return length;
    }
 
    
    public void printListFromForward(){
    	if(head==null){
    		return;
    	}
    	Node temp=head;
    	while(temp!=null){
    		System.out.print(temp.data+"-->");
    		temp=temp.next;
    	}
    	System.out.println("null");
    }
    
    public void printListFrombackword(){
    	if(tail==null){
    		return;
    	}
    	Node temp=tail;
    	while(temp!=null){
    		System.out.print(temp.data+"-->");
    		temp=temp.previous;
    	}
    	System.out.println("null");
    }
    
    public void insertNodeAtBeginning(int data){
    	Node newNode=new Node(data);
    	if(isEmptyList()){
    		head=tail=newNode;
    	}else{
    		newNode.next=head;
    		head.previous=newNode;
    		head=newNode;
    		
    	}
    	length++;
    }
    
    
    public void insertNodeAtLast(int data){
    	Node newNode=new Node(data);
    	if(isEmptyList()){
    		head=newNode;
    	}else{
    		tail.next=newNode;
    	}
    	newNode.previous=tail;
    	tail=newNode;
    	length++;
    }
    
    public void insertNodeAtspecificPosition(int data,int pos){
    	Node newNode=new Node(data);
    	if(isEmptyList() || pos>length){
    		return;
    	}
    	Node currentNode=head;
    	Node prevNode=head;
    	
    	//if pos=3 then it will go to pos 3 and 2 node a current and prev node and between these two it will insert new node
    	for(int i=0;i<pos-1;i++){
    	prevNode=currentNode;
    	currentNode=currentNode.next;
    	}
    	newNode.previous=prevNode;
    	newNode.next=prevNode.next;
    	prevNode.next=newNode;
    	currentNode.previous=newNode;
    	length++;
    }
    
    public void deleteNodeFrimBeginning(){
    	if(isEmptyList()){
    		return;
    	}
    	Node temp=head;
    	if(head==tail){
    		head=tail=null;
    	}else{
    		head.next.previous=null;
    	}
    	head=head.next;
    	temp.next=null;
    	temp=null;
    	length--;
    }
    
    public void deleteNodeFromLast(){
    	if(isEmptyList()){
    		return;
    	}
    	Node temp=tail;
    	if(head==tail){
    		head=tail=null;
    	}else{
    		tail.previous.next=null;
    	}
    	tail=tail.previous;
    	temp.previous=null;
    	temp=null;
    	length--;
    }
    
    public void deleteNodeAtspecificPositionFromHead(int pos){
    	if(isEmptyList() || pos>length){
    		return;
    	}
    	Node currentNode=head;
    	Node prevNode=head;
    	
    	//if pos=3 then it will go to pos 3 and 2 node a current and prev node and between these two it will insert new node
    	for(int i=0;i<pos-1;i++){
    	prevNode=currentNode;
    	currentNode=currentNode.next;
    	}
    	prevNode.next=currentNode.next;
    	//suppose the current node is last node then there wont be node so there wont be previous pointer 
    	if(currentNode.next!=null){
    	currentNode.next.previous=currentNode.previous;
    	}
    	currentNode=null;
    	length--;
    }
    public static void main(String[] args) {
    	DoublyLinkedListPract d=new DoublyLinkedListPract();
    	d.insertNodeAtLast(1);
    	d.insertNodeAtLast(4);
    	d.insertNodeAtLast(2);
    	d.insertNodeAtLast(8);
    	d.printListFromForward();
    	d.deleteNodeAtspecificPositionFromHead(4);
    	d.printListFromForward();
    	
        
	}
}
