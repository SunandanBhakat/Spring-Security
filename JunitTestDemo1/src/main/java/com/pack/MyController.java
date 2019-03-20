package com.pack;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	@RequestMapping(value="/")
	public String home(ModelMap map)
	{
		Date date=new Date();
		map.addAttribute("now",date);
		
		return "index";
	}
	
	@RequestMapping(value="/message")
	@ResponseBody //Response Body for JUnitesting
	public String message()
	{
		
		
		return "Hello World";
	}
	
}
