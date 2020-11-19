package com.suraj.ds;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class StringPract {
public static void main(String[] args) {
	String str = "geeks for geeks"; 
	swapChar(str);
	removeLeadingZeroes("0000001233000");
	queue();
	
	distinctWindOfChars("xyxyabcdefffxyze");
	System.out.println(distinctWithUniqueChars("karap",2));
	distinctWithAllSubstringsOfK("aabccc",2);
	smallWindOfChars("thhhis is atest string","tis");
	String reverse=reverseString("123ABC456xyz");
	System.out.println(reverse);
}
public static void swapChar(String s){
	//swap 1st and last char in each word
	String arr[]=s.split(" ");
	String finalString="";
	for(String a:arr){
		String word="";
		int n=a.length();
		char c[]=a.toCharArray();
		for(int i=0;i<n;i++){
			if(i==0){
				word=word+c[n-1];
			}else if(i==n-1){
				word=word+c[0];
			}else{
				word=word+c[i];
			}
		}
		if(finalString.isEmpty()){
			finalString=word;
		}else
		finalString=finalString+" "+word;
	}
	System.out.println(finalString);
}
public static void removeLeadingZeroes(String s){
	//00001233
	int i=0;
	while(i<=s.length()-1){
		if(s.charAt(i)!='0'){
			break;
		}
		i++;
	}
	System.out.println(s.substring(i));
}
public static void queue(){
	PriorityQueue<Integer> p=new PriorityQueue<Integer>(new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2-o1;
		}
	});
	p.add(2);
	p.add(4);
	p.add(1);
	p.add(9);
	System.out.println(p.peek());
}
public static void smallWindOfChars(String s,String p){
	/*Input: string = “this is a test string”, pattern = “tis”
			Output: Minimum window is “t stri”*/
	//"thhyhis is a test string","tis"
	char c[]=p.toCharArray();
	char str[]=s.toCharArray();
	List<Character> listOfChars=new ArrayList<Character>();
	
	String smallWindow=s;
	Set<Character> set=new HashSet<>();
	for(int i=0;i<=c.length-1;i++){
		listOfChars.add(c[i]);
	}
	int startIndex=0;
	for(int i=0;i<str.length-1;i++){
		startIndex=i;
		String windows="";
		for(int j=i;j<str.length-1;j++){
		if(listOfChars.contains(str[j])){
			if(set.size()<c.length && !set.contains(str[j])){
			set.add(str[j]);
			startIndex++;
			}
		}else{
		startIndex++;
		}
		if(set.size()==c.length){
			
			for(int k=i;k<=startIndex-1;k++){
				windows=windows+str[k];
			}
			if(smallWindow.length()>windows.length()){
				smallWindow=windows;
			}
			set.clear();
		//	break;
		}
		}
		
		/*for(int k=i;k<=startIndex-1;k++){
			windows=windows+str[k];
		}*/
		
		//i=startIndex;
	}		
	System.out.println(smallWindow);
}


public static void distinctWindOfChars(String s){
	/*Input  : aabcbcdbca
	Output : dbca*/
	char c[]=s.toCharArray();
	int n=c.length;
	Map<Character,Integer> map=new LinkedHashMap<>();
	String smallWindow="";
	int windowLength=0;
	for(int i=0;i<=n-1;i++){
		int start=i;
		if(!map.containsKey(c[i])){
			map.put(c[i], i);
		}else{
			i=map.get(c[i]);
			map.clear();
		}
		if(map.size()>windowLength){
			windowLength=map.size();
			smallWindow=map.keySet().toString();
		}
	}
	System.out.println(smallWindow);
}

public static String distinctWithUniqueChars(String s,Integer k){
	int start = 0,end=0;
	int windowSize=1;
	int windowStart=0;
	
	char c[]=s.toCharArray();
	int n=c.length;
	Map<Character,Integer> map=new LinkedHashMap<>();
	//karap",2
	for(int i=0;i<=n-1;i++){
		
		if(!map.containsKey(c[i])){
			map.put(c[i], 1);
		}else{
			map.put(c[i], map.get(c[i])+1);
		}
		end++;
		if(isCountGreaterInMap(map,k)){
			map.put(c[start], map.get(c[start])-1);
			start++;
		}
		if(end-start+1 >windowSize){
			windowSize=end-start+1;
			windowStart=start;
		}
	}
	return s.substring(windowStart, windowSize);
}
public static boolean isCountGreaterInMap(Map<Character,Integer> map,Integer k){
	int count=0;
	Set<Character> set=map.keySet();
	for(Character c:set){
		if(map.get(c)>0){
			count++;
		}
	}
	if(count > k){
	return true;
	}else{
	return false;	
	}
}

public static List<String> distinctWithAllSubstringsOfK(String s,Integer k){
	int start = 0,end=0;
List<String> list=new ArrayList<String>();
	
	char c[]=s.toCharArray();
	int n=c.length;
	Map<Character,Integer> map=new LinkedHashMap<>();
	//aabccc
	for(int i=0;i<=n-1;i++){
		
		if(!map.containsKey(c[i])){
			map.put(c[i], 1);
		}else{
			map.put(c[i], map.get(c[i])+1);
		}
		end++;
		if(isCountEqualToKInMap(map,k)){
			map.put(c[start], map.get(c[start])-1);
			
			list.add(s.substring(start,end));
			start++;
		}
		
	}
	System.out.println(list);
	return list;
}

public static boolean isCountEqualToKInMap(Map<Character,Integer> map,Integer k){
	Set<Character> set=map.keySet();
	boolean flag=true;
	for(Character c:set){
		if(map.get(c)!=k){
			flag=false;
			break;
		}
	}
	return flag;
	
}

public static String reverseString(String input){
char[] c = input.toCharArray();
int n=c.length; 
String output="";
for (int i =n-1; i >= 0; i--){
    output=output+c[i];
}
return output;
}
}
