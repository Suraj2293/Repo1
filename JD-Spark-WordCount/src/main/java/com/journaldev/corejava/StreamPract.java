package com.journaldev.corejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamPract {
	static public String f1="";
	 static String rev1="";

	
public static void main(String[] args) {
	List<String> list1=Arrays.asList("abc","surja","suraj","swaraj2");
	List<String> list2=Arrays.asList("abc","akash","suraj1","swaraj","rutvik");
	List<String> list3=list1.stream().filter((x -> !list2.contains(x))).collect(Collectors.toList());
	System.out.println(list3);
	List<List<String>> list4=Stream.concat(Stream.of(list1), Stream.of(list2)).collect(Collectors.toList());
	System.out.println(list4);
	List<String> list5=list4.stream().flatMap(l -> l.stream()).collect(Collectors.toList());
	System.out.println(list5);
	List<String> names = new ArrayList<>();
    
	names.add("David");
	        
	names.add("Johnson");
	         
	names.add("Samontika");
	         
	names.add("Brijesh");
	         
	names.add("John");
	         
	if(names.stream().anyMatch((String name) -> name.length() == 5))
	{
	    System.out.println("Yes... There is a name exist with 5 letters");
	}	
	
	Stream.of("a1", "a2", "a3")
    .map(s -> s.substring(1))
    .mapToInt(x -> Integer.parseInt(x))
    .max()
    .ifPresent(System.out::println);
	
	int l=IntStream.of(1,2,3,4,5).min().getAsInt();
	System.out.println(l);
//============================================
	Stream.of("a1", "a2", "a3").map(a -> a.substring(1)).map(a -> Integer.parseInt(a)).sorted(Comparator.reverseOrder()).forEach(a -> System.out.print(a));
	
	List<Person1> persons =
		    Arrays.asList(
		        new Person1("Max", 18),
		        new Person1("Peter", 23),
		        new Person1("Pamela", 23),
		        new Person1("Pamela", 30),
		        new Person1("David", 12),
		        new Person1("Pamela", 12));
	
	Map<Object,List<Person1>> p=persons.stream().filter(x -> x.age<24).collect(Collectors.groupingBy(x -> x.age));
	System.out.println(p);
	Map<Object, Object> map = persons
		    .stream()
		    .collect(Collectors.toMap(
		        c -> c.name,
		        c -> c.age,
		        (name1, name2) -> Integer.parseInt(name1.toString())+Integer.parseInt(name2.toString())));
	System.out.println(map);
	
	//Use forEach when to write into instance variable like map or list	
	Map<String,Integer> finalMap1=new HashMap<String, Integer>();
             persons
		    .stream()
		    .forEach(a -> finalMap1.put(a.getName(),finalMap1.get(a.getName())!=null?finalMap1.get(a.getName())+a.getAge():a.getAge()));
             
    System.out.println(finalMap1);  
    //======================================================================================================================
    
    List<List<String>> namesNested = Arrays.asList( 
    	      Arrays.asList("Jeff", "Bezos"), 
    	      Arrays.asList("Bill", "Gates"), 
    	      Arrays.asList("Mark", "Zuckerberg"));

    	    List<String> namesFlatStream = namesNested.stream().flatMap(s -> s.stream()).collect(Collectors.toList());
    	    System.out.println(namesFlatStream);
    	    
//============================================================================================================================    	    
   // persons.stream().toArray(Person[] :: new);
  /*  l.stream().sorted((a,b) -> {if(a.getCityName().equals(b.getCityName())){
    	return b.getId()-a.getId();
    }
    else{
    	return b.getCityName().compareTo(a.getCityName());}
    }).collect(Collectors.toList()).forEach(System.out::println);*/

    //string 
String s1="Java Concept Of The Day";
Arrays.stream(s1.split(" ")).forEach(a -> f1=a+" "+f1);
System.out.println(f1);
String rev="suraj";

Stream.of(rev.split("")).forEach(a -> rev1=a+""+ rev1);
System.out.println(rev1);
String aaa=Stream.of("suraj".split("")).collect(Collectors.joining(","));
System.out.println(aaa);
System.out.println("=============================");
Stream.of("suraj".split("")).collect(Collectors.toCollection(LinkedList::new)).descendingIterator().forEachRemaining(a -> System.out.print(a));
//sorted reverse order for non custom objects like integer or string
System.out.println("=============================");
List<Integer> l1=Arrays.asList(1, 2, 1, 3, 4, 2, 3).stream().sorted().collect(Collectors.toList());
System.out.println(l1);

Arrays.asList(1, 2, 1, 3, 4, 2, 3).stream().collect(Collectors.toCollection(LinkedList::new))
.descendingIterator().forEachRemaining(System.out::print);

List<Integer> l2=Arrays.asList(1, 2, 1, 3, 4, 2, 3).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
System.out.println(l2);

Optional<Integer> l3=Arrays.asList(1, 2, 1, 3, 4, 2, 3).stream().min((a,b) -> a-b);
System.out.println(l3.get());

Optional<Integer> l4=Arrays.asList(1, 2, 1, 3, 4, 2, 3).stream().max((a,b) -> a-b);
System.out.println(l4.get());

OptionalDouble l5=Arrays.asList(1, 2, 1, 3, 4, 2, 3).stream().mapToInt(a -> a).average();
System.out.println(l5.getAsDouble());

List<String> list = Arrays.asList("9", "A1", "AZ", "1", "AB", "Y", "4", "Aa", "c");

list=list.stream().filter(a -> a.startsWith("A")).map(a -> a.toUpperCase()).sorted((a,b) -> b.compareTo(a)).collect(Collectors.toList());
System.out.println(list);


//===========================================================================List remove element from java 8=====================
List<String> listRemove=new ArrayList<String>();
listRemove.add("rutu");
listRemove.add("rutu1");
listRemove.add("swaru");
listRemove.add("swaraj");

listRemove.removeIf(a -> a.contains("swa"));
System.out.println(listRemove);
List<String> str1 = new ArrayList<String>();
str1.add("A");
str1.add("B");
str1.add("C");
str1.add("D");

List<String> str2 = new ArrayList<String>();
str2.add("D");
str2.add("E");

//str1.removeIf(x -> str2.contains(x));
str1.removeIf(a -> a.startsWith("A"));

str1.forEach(System.out::println);
}}
