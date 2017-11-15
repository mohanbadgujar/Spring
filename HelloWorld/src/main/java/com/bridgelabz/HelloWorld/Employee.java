package com.bridgelabz.HelloWorld;

public class Employee {
	private String name;

	
	//constructor to check constructor dependancy
	public Employee(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	//setter method to check dependancy using setter method
	public void setName(String name) {
		this.name = name;
	}
	
	public void name() {
		System.out.println("Hello"+name);
	}
}
