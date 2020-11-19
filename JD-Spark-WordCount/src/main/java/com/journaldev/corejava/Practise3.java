package com.journaldev.corejava;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Practise3 {
public static void main(String[] args) {
	System.out.println("3");
	Thread t =new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("4");
			System.out.println("6");
		}
	});
	t.start();
	System.out.println("5");
	/*List<String> loans = new CopyOnWriteArrayLis
	 * t<>();	
	loans.add("personal loan");
	loans.add("home loan");
	loans.add("auto loan");
	loans.add("credit line loan");
	loans.add("mortgage loan");
	loans.add("gold loan");
	loans.add("A");
//	System.out.println(loans);
	for (String loan : loans) {
	//	System.out.print(loan+" ");
		if (loan.equals("A")) {
			
			loans.remove(loan);
			loans.add("abd");

		}
	
	}
	System.out.println(loans);*/
}
}
