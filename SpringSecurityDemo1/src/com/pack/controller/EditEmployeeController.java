package com.pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;


import com.pack.model.Employee;
import com.pack.service.EmployeeService;

@Controller
public class EditEmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value="/list")//default is get method
	public String listEmployee(ModelMap map)
	{
		List<Employee> list=employeeService.listEmployees();
		map.addAttribute("employee", new Employee());
		map.addAttribute("employeeList",list);
		
		
		return "employeeList";//name to be searched in jsp i.e. jsp file to be searched and returned. 
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee")Employee employee)//Mapped to command object
	{
		Random random=new Random();
		int num=random.nextInt(900000)+100000;
		employee.setId(num);
		employeeService.addEmployee(employee);
		
		
		
		
		return "redirect:/list";
	}
	
	
	@RequestMapping(value="/delete/{eid}")
	public String deleteCustomer(@PathVariable("eid")Integer empId)
	{
		//removeCustomer(customerId);
		employeeService.deleteEmployee(empId);
		
		return "redirect:/list";
	}
	
	
	@RequestMapping(value="/login")
	public String login(ModelMap map)
	{
		
		return "login";
	}
	
	@RequestMapping(value="/accessdenied", method=RequestMethod.GET)
	public String loginError(ModelMap model)
	{
		model.addAttribute("error","true");
		
		return "denied";
	}
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(ModelMap model)
	{
		
		return "logout";
	}
	
	
}
