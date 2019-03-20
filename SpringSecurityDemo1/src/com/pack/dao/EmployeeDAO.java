package com.pack.dao;

import java.util.List;

import com.pack.model.Employee;

public interface EmployeeDAO {
	
	public void addEmployee(Employee e);
	public List<Employee> listEmployees();
	public void deleteEmployee(int id);

}
