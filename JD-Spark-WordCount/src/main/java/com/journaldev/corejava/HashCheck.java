package com.journaldev.corejava;

public class HashCheck {
public static void main(String[] args) {
	String s1="suraj";
	String s2="suraj";
	String s3=new String("suraj");
	
	System.out.println(new City(1,"").hashCode());
	System.out.println(new City(1,"").hashCode());
	System.out.println(s1==s3);
	System.out.println(s1.hashCode()==s2.hashCode());//true
	System.out.println(s1.hashCode()==s3.hashCode());//true
	
}
}
