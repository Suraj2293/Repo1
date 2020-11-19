package com.journaldev.corejava;
/*public class MainClass extends City implements Abc,Abd {

	public static void main(String[] args) {
Inventory<Item> item=new Inventory<Item>();
for(Item i : Item.values()){
    item.put(i,5);
}

System.out.println(item.getQuantity(Item.COKE));
N n=new N();



	}

	@Override
	public String draw(int a, String s) {	
		// TODO Auto-generated method stub
		return null;
	}

	
	
	}
*/
class Ab
{
   /* void method(int a)
    {
        System.out.println("ONE");
    }*/
     
    void method(double d)
    {
        System.out.println("TWO");
    }
    void method(Number d)
    {
        System.out.println("number");
    }
}
 
class Bc extends Ab
{
    @Override
    void method(double d)
    {
        System.out.println("THREE");
    }
    @Override
    void method(Number d)
    {
        System.out.println("number");
    }
}
 
public class MainClass 
{   
    public static void main(String[] args)
    {
        new Bc().method(100);
        Bc b=new Bc();
        Ab a=new Ab();
        Bc x=(Bc)a;
        System.out.println(b.hashCode());
        
        //b=new Bc();
        
    }
}




