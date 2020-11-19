package com.journaldev.corejava;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class LambdaPract {
public String add(Foo f){
	return f.method("add");
}
public String add1(PredicatePract f){
	return f.method("add");
}
public static void main(String[] args) {
	String r=new LambdaPract().add(new Foo() {
		
		@Override
		public String method(String s) {
			return "add"+s;
		}
	});
String r1=new LambdaPract().add(a -> "add"+a);
String r2=new LambdaPract().add(new A());
	System.out.println(r2);
	PredicatePract<String> p=a -> a+"ssss";
	PredicatePract<City> p1=a -> a.cityName+"ssss";
	Predicate<Integer> lesserthan = i -> (i < 18);  
	Predicate<City> c=q ->q.cityName.equals("dzd");
	
	String s=new LambdaPract().add1(p);
	System.out.println(s);
	
	List<List<String>> namesNested = Arrays.asList( 
		      Arrays.asList("Jeff", "Bezos"), 
		      Arrays.asList("Bill", "Gates"), 
		      Arrays.asList("Mark", "Zuckerberg"));
	System.out.println(namesNested.stream().flatMap(a -> a.stream()).collect(Collectors.toList()));
	Foo f=name -> {  
        return "Hello, "+name;  
    };  
    Foo f1=abc -> "";
	

}

}
@FunctionalInterface
interface Foo{
	String method(String s);
} 

@FunctionalInterface
interface PredicatePract<T>{
	String method(T s);
} 

class A implements Foo{

	@Override
	public String method(String s) {
		return "add"+s;
	}
	
}