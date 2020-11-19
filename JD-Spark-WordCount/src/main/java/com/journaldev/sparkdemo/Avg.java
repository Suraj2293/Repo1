package com.journaldev.sparkdemo;





import java.io.Serializable;

public class Avg implements Serializable{

private static final long serialVersionUID = 1L;

private int sum;
private int num;

public Avg(int sum, int num){
this.sum = sum;
this.num = num;
}

public double getAvg(){ return (this.sum / this.num);}

public int getSum(){    return this.sum;    }

public int getNum(){        return this.num;    }
}