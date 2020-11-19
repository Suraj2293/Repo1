package com.journaldev.corejava;
public class Employee implements Cloneable{
	 
    private int empoyeeId;
    private String employeeName;
    //mutable custom object which affects in cloning if w changed
    private Department department;
 
    public Employee(int id, String name, Department dept)
    {
        this.empoyeeId = id;
        this.employeeName = name;
        this.department = dept;
    }
   
	public int getEmpoyeeId() {
		return empoyeeId;
	}
	public void setEmpoyeeId(int empoyeeId) {
		this.empoyeeId = empoyeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
     
    //Getters and Setters
	
	//uncomment for Shallow copy
	/* @Override
	    protected Object clone() throws CloneNotSupportedException {
	        return super.clone();
	    }
	 */
	
	// uncomment for deep copy
	@Override
	protected Object clone() throws CloneNotSupportedException {
	    Employee cloned = (Employee)super.clone();
	    cloned.setDepartment((Department)cloned.getDepartment().clone());   
	    return cloned;
	}
    
}
