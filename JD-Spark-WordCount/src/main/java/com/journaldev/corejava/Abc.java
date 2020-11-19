package com.journaldev.corejava;

public interface Abc {
public String draw(int a,String s);
public default String drawa(int a){
	return "";
}
 default void show(){
	System.out.println("Abc");
}
}
