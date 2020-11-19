package com.journaldev.corejava;

public class Department implements Cloneable
{
    private int id;
    private String name;
 
    public Department(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
 
 //comment for shallow copy and uncomment for deep
	@Override
	protected Object clone() throws CloneNotSupportedException {
	    return super.clone();
	}
    
}
