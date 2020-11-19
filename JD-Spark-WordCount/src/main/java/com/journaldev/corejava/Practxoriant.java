package com.journaldev.corejava;

public class Practxoriant {

	    public static void main (String argv[]) {
	        boolean b1 = true;
	        if ((b1 == true) || place(true)) {
	            System.out.println("C");
	        }
	    }

	    public static boolean place (boolean location) {
	        if (location == true) {
	            System.out.println ("B") ;
	        }
	        System.out.println ("A") ;
	        return true;
	    }
	}

