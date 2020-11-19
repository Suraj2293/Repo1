package com.journaldev.corejava;


public class Person implements Cloneable {
String name;
Integer age;
City city;
public Person(String name, Integer age, City city) {
	super();
	this.name = name;
	this.age = age;
	this.city = city;
}
@Override
public String toString() {
	return "Person [name=" + name + ", age=" + age + ", city=" + city + "]";
}

public Person clone() throws CloneNotSupportedException{
	Person cloneObj= (Person) super.clone();
	cloneObj.city=this.city.clone();
	return cloneObj;
	//return (Person) super.clone();
}

@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((city == null) ? 0 : city.hashCode());
    result = prime * result + age;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
}
@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Person other = (Person) obj;
    if (city == null) {
        if (other.city != null)
            return false;
    } else if (!city.equals(other.city))
        return false;
    if (age != other.age)
        return false;
    if (name == null) {
        if (other.name != null)
            return false;
    } else if (!name.equals(other.name))
        return false;
    return true;
}
	
}
