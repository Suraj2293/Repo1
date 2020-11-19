package com.journaldev.corejava;

public class City implements Cloneable{
Integer id;
String cityName;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getCityName() {
	return cityName;
}
public void setCityName(String cityName) {
	this.cityName = cityName;
}
@Override
public String toString() {
	return "City [id=" + id + ", cityName=" + cityName + "]";
}

public City clone() throws CloneNotSupportedException{
	return (City) super.clone();
}
public City(){
	
}

public City(Integer id, String cityName) {
	super();
	this.id = id;
	this.cityName = cityName;
}
public void show(){
	System.out.println("cty class");
}
/*
@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((cityName == null) ? 0 : cityName.hashCode());
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
    City other = (City) obj;
    if (cityName == null) {
        if (other.cityName != null)
            return false;
    } else if (!cityName.equals(other.cityName))
        return false;
    return true;
}*/
}
