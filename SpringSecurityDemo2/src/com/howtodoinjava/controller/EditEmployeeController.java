package com.howtodoinjava.controller;
 
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
import com.howtodoinjava.entity.EmployeeEntity;
import com.howtodoinjava.service.EmployeeManager;
 
@Controller
public class EditEmployeeController {
 
    @Autowired
    private EmployeeManager employeeManager;
    private static Logger log=Logger.getLogger(EditEmployeeController.class);//logger
 
    public void setEmployeeManager(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }
 
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String defaultPage(ModelMap map) {
        return "redirect:/list";
    }
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listEmployees(ModelMap map) {
 
        map.addAttribute("employee", new EmployeeEntity());
        map.addAttribute("employeeList", employeeManager.getAllEmployees());
        
        if(log.isDebugEnabled())//logger 
        {
        	log.debug("Start debug");
        }
        log.info("Going to list employee");
        log.info("Exiting List employee");
 
        return "editEmployeeList";
    }
 
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addEmployee(
            @ModelAttribute(value = "employee") EmployeeEntity employee,
            BindingResult result) {
    	Random r=new Random();
    	int num=r.nextInt(900000)+100000;
    	employee.setId(num);
        employeeManager.addEmployee(employee);
        
        if(log.isDebugEnabled())
        {
        	log.debug("Start debug");
        }
        log.info("Going to add Employee");
        log.info("Exiting add Employee");
        
        return "redirect:/list";
    }
 
    @RequestMapping("/delete/{employeeId}")
    public String deleteEmplyee(@PathVariable("employeeId") Integer employeeId) {
        employeeManager.deleteEmployee(employeeId);
        if(log.isDebugEnabled())
        {
        	log.debug("Start debug");
        }
        log.info("Going to delete employee");
        log.info("Exiting delete employee");

        
        return "redirect:/list";
    }
 
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
    	
    	 if(log.isDebugEnabled())
         {
         	log.debug("Start debug");
         }
         log.info("Going to login employee");
         log.info("Exiting login employee");

        return "login";
    }
 
    @RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
    public String loginerror(ModelMap model) {
        model.addAttribute("error", "true");
        
        if(log.isDebugEnabled())
        {
        	log.debug("Start debug");
        }
        log.info("Going to loginerror employee");
        log.info("Exiting loginerror employee");

        return "denied";
    }
 
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
    	
    	 if(log.isDebugEnabled())
         {
         	log.debug("Start debug");
         }
         log.info("Going to logout employee");
         log.info("Exiting logout employee");

        return "logout";
    }
}