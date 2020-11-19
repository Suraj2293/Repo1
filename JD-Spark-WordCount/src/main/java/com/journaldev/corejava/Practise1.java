package com.journaldev.corejava;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.hadoop.yarn.webapp.hamlet.HamletSpec.B;

public class Practise1 {
	 String name;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Practise1 other = (Practise1) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public static void main(String[] args) {
		
City c1=new City();
c1.setId(1);
c1.setCityName("Mumbai");
City c2=new City();
c2.setId(2);
c2.setCityName("Thane");

City c3=new City();
c3.setId(4);
c3.setCityName("Thane");

City c4=new City();
c4.setId(5);
c4.setCityName("Jogeshwari");

City c5=new City();
c5.setId(9);
c5.setCityName("Andheri");

List<City> l=new ArrayList<City>();
l.add(c1);
l.add(c2);
l.add(c3);
l.add(c4);
l.add(c5);

l.stream().sorted((a,b) -> {if(a.getCityName().equals(b.getCityName())){
	return b.getId()-a.getId();
}
else{
	return b.getCityName().compareTo(a.getCityName());}
}).collect(Collectors.toList()).forEach(System.out::println);


}
}
