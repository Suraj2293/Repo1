package com.journaldev.corejava;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorServicePract1 {
public static void main(String[] args) throws InterruptedException, ExecutionException {
	ExecutorService e=Executors.newFixedThreadPool(2);
	List<Future<Integer>> l=new ArrayList<Future<Integer>>();
	
	for (int i=1;i<6;i++){
	Future<Integer> f=e.submit(new Callable<Integer>() {
    
		@Override
		public Integer call() throws Exception {
			System.out.println("before going to sleep "+Thread.currentThread().getId());
			Thread.sleep(10000);
			System.out.println("after sleep "+Thread.currentThread().getId());
			return 3;
		}
	});
	l.add(f);
	/*
	 To run the sinle task and get rhe future result by hecking task done or not
	 System.out.println("before while"+f.isDone());
	while(f.isDone()==false){
		try {
			//System.out.println("in while"+f.isDone());
			System.out.println(f.get());
			System.out.println("after result while"+f.isDone());
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			e1.printStackTrace();
		}
	}*/
	
	}
	//============
	System.out.println("before future calling");
	List<Integer> intList=new ArrayList<Integer>();
	for(Future<Integer> future:l){
		Integer i=future.get();
		intList.add(i);
		System.out.println("result of task "+i);
	
	}
	System.out.println("listresult = "+intList.stream().reduce(0,(a,b) -> a+b));
	System.out.println("after future calling");
	System.out.println();
	System.out.println("invokeAll mehod started=====================");
	//================================== invokeAll method need to pass collection as parameter=======================================================
	
	List<Task> taskList = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
        Task task = new Task("Task-" + i);
        taskList.add(task);
    }
    List<Future<Result>> resultList=e.invokeAll(taskList);
    System.out.println("\n========Printing the results======");
    
    for (int i = 0; i < resultList.size(); i++) {
        Future<Result> future = resultList.get(i);
        try {
            Result result = future.get();
            System.out.println(result.getName() + ": " + result.getTimestamp());
        } catch (InterruptedException | ExecutionException e1) {
            e1.printStackTrace();
        }
    }
	e.shutdown();
}
}

class Task implements Callable<Result> 
{
    private final String name;
 
    public Task(String name) {
        this.name = name;
    }
 
    @Override
    public Result call() throws Exception 
    {
        System.out.printf("%s: Staring\n", this.name);
 
        try {
            long duration = (long) (Math.random() * 10);
            System.out.printf("%s: Waiting %d seconds for results.\n", this.name, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
        return new Result(this.name, LocalDateTime.now().toString());
    }
}


class Result 
{
    private String name;
    private String timestamp;
 
    public Result(String name, String timestamp) {
        super();
        this.name = name;
        this.timestamp = timestamp;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getTimestamp() {
        return timestamp;
    }
 
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
 
    @Override
    public String toString() {
        return "Result [name=" + name + ", value=" + timestamp + "]";
    }
}
