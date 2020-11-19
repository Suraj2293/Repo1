package com.journaldev.sparkdemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServicePract {

	public static void main(String[] args) throws InterruptedException {

CountDownLatch latch=new CountDownLatch(5);
 ExecutorService executor = Executors.newFixedThreadPool(2);			
for(int i=0;i<5;i++){
	executor.submit(new B(latch));
}
System.out.println("before latch await");
 latch.await();
 System.out.println("after latch await");

}
}
 class B implements Runnable{
	 CountDownLatch latch;
	 B(CountDownLatch latch){
		 this.latch=latch;
	 }
	 @Override
     public void run()
     {
         //Thread t1 started : Task is to print numbers from 0 to 1000"

         for(int i = 0; i <= 10; i++)
         {
             System.out.println(i);
         }
try {
	Thread.sleep(5000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
         System.out.println("Numbers from 0 to 10 are printed");
         latch.countDown();
     }
 }
 
 class C implements Runnable{
	 CountDownLatch latch;
	 C(CountDownLatch latch){
		 this.latch=latch;
	 }
	 @Override
     public void run()
     {
         //Thread t1 started : Task is to print numbers from 0 to 1000"

         for(int i = 10; i <= 20; i++)
         {
             System.out.println(i);
         }
         try {
        		Thread.sleep(10000);
        	} catch (InterruptedException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	}
         System.out.println("Numbers from 10 to 20 are printed");
         latch.countDown();
     }
 }
 class A{
	 int a=10;
		public void a(){
			System.out.println("method A");
		}
}