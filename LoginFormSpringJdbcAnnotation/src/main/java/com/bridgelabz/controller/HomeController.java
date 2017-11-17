package com.bridgelabz.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.model.User;
import com.bridgelabz.service.utility.SendEmail;

@Controller
public class HomeController {
	
	@Autowired
	private SendEmail sendMail; 
	
	@RequestMapping(value="/")
	public String homePage()
	{
		return "login"; 
	}
	
	@RequestMapping(value="/forgotPassword")
	public String forgotPassword()
	{
		return "forgotPassword"; 
	}
	
	@RequestMapping(value="/resetPassword" , method=RequestMethod.POST)
	public String resetRequest(@RequestParam(value="email") String email)
	{
		//check if the email id is valid and registered with us.
		sendMail.sendMail(email);
		return "checkMail";
	}
	
	@RequestMapping(value="/newPassword/{email}" )
	public String resetPassword(@PathVariable String email,Map<String,String> model)
	{
		//check if the email id is valid and registered with us.
		model.put("emailid", email);
		return "newPassword";
	}

}
