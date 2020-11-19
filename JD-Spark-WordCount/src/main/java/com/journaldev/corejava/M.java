package com.journaldev.corejava;

public class M {

public static void main(String[] args) {
	 X x = new Y();
     
     x.calculate(10, 20);
      
     Y y = (Y) x;
      
     y.calculate(50, 100);
      
  /*   Z z = (Z) y;
      
     z.calculate(100, 200);*/
     Y a=new Y();
     a.superClassMethod(1234.22);
     X s=new Y();
     s.a();
}
}
class X
{
    void calculate(int a, int b)
    {
        System.out.println("Class X");
    }
    void superClassMethod(Number n)
    {
        System.out.println("From Super Class");
    }
    public static void a(){
    	System.out.println("class x");
    }
}
 
class Y extends X
{
    @Override
    void calculate(int a, int b)
    {
        System.out.println("Class Y");
    }
    void superClassMethod(double n)
    {
        System.out.println("From child Class");
    }
    
    public static void a(){
    	System.out.println("class x child static");
    }
}
 
class Z extends Y
{
    @Override
    void calculate(int a, int b) 
    {
        System.out.println("Class Z");
    }
}
