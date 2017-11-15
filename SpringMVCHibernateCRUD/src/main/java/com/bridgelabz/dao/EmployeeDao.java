package com.bridgelabz.dao;

import java.util.List;

import com.bridgelabz.model.Employee;

public interface EmployeeDao {

	public void addEmployee(Employee employee);
	
	public List<Employee> getAllEmployee();
	
	public void deleteEmployee(Integer empid);
	
	public Employee updateEmployee(Employee employee);
	
	public Employee getEmployee(int employeeid);
}
