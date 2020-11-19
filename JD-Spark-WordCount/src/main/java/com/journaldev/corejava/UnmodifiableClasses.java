package com.journaldev.corejava;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UnmodifiableClasses {
public static void main(String[] args) {
	Map<String, Integer> stringMap = new HashMap<String, Integer>(); 
	stringMap.put("a", 1); 
	stringMap.put("b", 2);
	stringMap.put("c", 3);
	stringMap = Collections.unmodifiableMap(stringMap);
	System.out.println(stringMap);
	//stringMap.put("", 1);
	
}
}
