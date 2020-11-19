package com.journaldev.sparkdemo;

public class Person {
private Integer id;
private String name;
private String state;


public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
void a(){
	System.out.println("a method");
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "Person [id=" + id + ", name=" + name + "]";
}

}

