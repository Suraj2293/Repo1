package com.datastructure.binarytree;

import java.util.Stack;


public class BinaryTreePract {
    private TreeNode root;
    int a=0;
    int b=1;
    int c;
	
	public static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int data) {
		this.data=data;
		}
	}
	
	public BinaryTreePract() {
		this.root=null;	
	}
	
	public void createBinaryTree(){
		TreeNode first=new TreeNode(1);
		TreeNode second=new TreeNode(2);
		TreeNode third=new TreeNode(3);
		TreeNode fourth=new TreeNode(4);
		TreeNode five=new TreeNode(5);
		root=first;
		first.left=second;
		first.right=third;
		second.left=fourth;
		second.right=five;
		
	}
	
	public void preOrderRecursive(TreeNode root){
		if(root==null){
			return;
		}
		System.out.print(root.data + " ");
		preOrderRecursive(root.left);
		preOrderRecursive(root.right);

	}
	
	public void preOrderIterative(){
		if(root==null){
			return;
		}
		Stack<TreeNode> stack=new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode temp=stack.pop();
			System.out.print(temp.data+ " ");
			if(temp.right!=null){
				stack.push(temp.right);
			}
			if(temp.left!=null){
				stack.push(temp.left);
			}
				
		}
	}
	public void inOrderRecursive(TreeNode root){
		if(root==null){
			return;
		}
		
		inOrderRecursive(root.left);
		System.out.print(root.data + " ");
		inOrderRecursive(root.right);

	}
	
	public void inOrderIterative(){
		if(root==null){
			return;
		}
		Stack<TreeNode> stack=new Stack<>();
		TreeNode temp=root;
		while(!stack.isEmpty() || temp!=null){
			
			if(temp!=null){
				stack.push(temp);
				temp=temp.left;
			}else{
			temp=stack.pop();
			System.out.print(temp.data + " ");
			temp=temp.right;
			}
				
		}
	}
	public void postOrderRecursive(TreeNode root){
		if(root==null){
			return;
		}
		
		postOrderRecursive(root.left);
		postOrderRecursive(root.right);
		System.out.print(root.data + " ");
		

	}
	
	public Integer sumOfNodes(TreeNode root){
		if(root==null){
			return 0;
		}
		return root.data+sumOfNodes(root.left)+sumOfNodes(root.right);
	}
	
	public Integer differenceOddEvenOfNodes(TreeNode root){
		if(root==null){
			return 0;
		}
		return root.data-differenceOddEvenOfNodes(root.left)-differenceOddEvenOfNodes(root.right);
	}
	
	public Integer getNoOfNodes(TreeNode root){
		if(root==null){
			return 0;
		}
		return 1+getNoOfNodes(root.left)+getNoOfNodes(root.right);
	}
	
	public void fibo(int n){
		System.out.println(0);
		int first=0;
		int second=1;
		System.out.print(first);
		System.out.print(second);
		int third=0;
		for(int i=2;i<n;i++){
			third=first+second;
			System.out.print(third);
		    first=second;
		    second=third;
			
		}
	}
	 public int fiboRec(int n){
		 if(n==1 || n==2){
			 return 1;
		 }
		 else{
			 return fiboRec(n-1)+fiboRec(n-2);
		 }
	 }
	 
	 public void fiboPrintRec(int n){
		 if(n>=3){
			 c=a+b;
			 System.out.print(c);
			 a=b;
			 b=c;
			 fiboPrintRec(n-1);
		 }
	 }
	public static void main(String[] args) {
		BinaryTreePract b=new BinaryTreePract();
		b.createBinaryTree();
		b.preOrderRecursive(b.root);
		System.out.println();
		b.preOrderIterative();
		System.out.println();
		b.inOrderRecursive(b.root);
		System.out.println();
		b.inOrderIterative();
		System.out.println();
		b.postOrderRecursive(b.root);
		System.out.println(b.sumOfNodes(b.root));
		System.out.println(b.differenceOddEvenOfNodes(b.root));
		System.out.println(b.getNoOfNodes(b.root));
		System.out.println();
		b.fibo(6);
		System.out.println();
		System.out.print(0);
		System.out.print(1);
		b.fiboPrintRec(6);
		
	}
}
