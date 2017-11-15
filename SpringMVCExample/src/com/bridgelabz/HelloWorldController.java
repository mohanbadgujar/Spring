package com.bridgelabz;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
/*@RequestMapping("/")*/
public class HelloWorldController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(ModelMap model) {
		model.addAttribute("msg", "Welcome to java from mohan");
		return "welcome";
	}
	
	@RequestMapping(value="greeting", method= RequestMethod.GET)
	public String greeting(ModelMap model) 
	{
		model.addAttribute("msg","Greeting from	mohan");
		return "welcome";
	}
}
