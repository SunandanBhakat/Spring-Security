package com.pack.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.dao.EmployeeDAO;
import com.pack.model.Employee;

@Service

public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDao;

	@Override
	@Transactional
	public void addEmployee(Employee e) {
		employeeDao.addEmployee(e);
		
		
		
		
	}

	@Override
	@Transactional
	public List<Employee> listEmployees() {
		
		List<Employee> list=employeeDao.listEmployees();
		
		return list;
	}

	@Override
	@Transactional
	public void deleteEmployee(int id) {
		
		employeeDao.deleteEmployee(id);
	}
	

}
