package com.journaldev.sparkdemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;


public class Practise extends Person{

	public static void main(String[] args) throws InterruptedException, ParseException {

		/*new Practise().toString();
		final Practise p=null;
		Person p1=new Person();
		p1.setId(1);
		p1.setName("suraj");
		
		Person p2=new Person();
		p2.setId(1);
		p2.setName("suraj");*/
		/*System.out.println(0);
		System.out.println(1);
		int first=0;
		int second=1;
		int n=7;
		int third=0;
		for(int i=2;i<n;i++){
			third=first+second;
			System.out.println(third);
			first=second;
			second=third;
			
		}*/
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
		String date=s.format(new Date());
		System.out.println(date);
		Date d1=s.parse(date);
		System.out.println(3*0.1);
		LocalDateTime ldt = LocalDateTime.now();

		System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(ldt));
	
		List<String> list = Arrays.asList( "bc","abc","cde","rde","erf");
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
		System.out.println(Thread.currentThread());
		Thread t=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("sdsds");
				try {
					System.out.println(Thread.currentThread().getName());
					Thread.sleep(5000);
					System.out.println("after xsleep");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		t.start();
		System.out.println(Thread.currentThread().getName());
        t.join();
		System.out.println(Thread.currentThread().getName());
		System.out.println("last stamnt");
		Map<String,String> m=new HashMap<>();
		m.put(null, "ab");
		m.put(null, "abc");
		System.out.println(m.get(null));
		
	
}

	public void b() throws InterruptedException{
		wait();
		a();
	}
	
	
	
	
	

}

	

