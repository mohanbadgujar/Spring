package com.bridgelabz.CrudRest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

	@RequestMapping("/")
	public String welcome()
	{
		return "Welcome in RestController Demo";
	}
	
}
