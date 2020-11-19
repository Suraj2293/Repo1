package com.journaldev.corejava;

public class OverridingPract {
public static void main(String[] args) {
	Parent p=new Child();
	p.a("abc");
	p.b();
}
	
}
class Parent{
	String name;
	public Parent(String name){
		this.name=name;
	}
	
	public void a(){
		System.out.println("a method");
	}
	
	public void a(String name){
		System.out.println("a method : "+name);
	}
	
	// static method dont get override so it call this method instead of child method
	public static void b(){
		System.out.println("b static  method");
	}
	
}
class Child extends Parent{
/*	public Child(String name) {
		super(name);
	}*/
	public Child() {
		super("");
	}
	public void a(){
		System.out.println("a method in child");
	}
	
	public void a(String name){
		System.out.println("a method in child : "+name);
	}
	public static void b(){
		System.out.println("b static child method");
	}
	
}