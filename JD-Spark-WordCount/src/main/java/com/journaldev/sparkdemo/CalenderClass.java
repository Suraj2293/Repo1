package com.journaldev.sparkdemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CalenderClass {

	public static void main(String[] args) throws ParseException {
		Calendar cal = Calendar.getInstance();	
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		Date d1 = simpleDateFormat.parse("2019-10-01");
		Date d2 = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(new Date());
		long diff=d1.getTime()-new Date().getTime();
		System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
		
	}

}
