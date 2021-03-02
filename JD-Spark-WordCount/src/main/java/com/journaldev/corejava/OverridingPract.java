package com.journaldev.corejava;

public class OverridingPract {
public static void main(String[] args) {
	Parent p=new Child();
	Child c=new Child();
	p.a("abc");
	p.b();
	c.b();
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
	// u cant even ovverride static method with same name but non static
	public static void b(){
		System.out.println("b static  parent method");
	}
	public final void c(){
		System.out.println("b static  parent method");
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
	
		// u cant even ovverride final method 
	/*public final void c(){
		System.out.println("b static  parent method");
	}*/
	
}