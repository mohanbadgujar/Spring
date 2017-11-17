package com.bridgelabz.service.utility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.model.User;
import com.bridgelabz.service.business.UserService;

@Controller
public class ResetPassword {

	@Autowired
	UserService service;
	
	/*@RequestMapping(value ="/resetpassword",method= RequestMethod.POST)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {

		User user = new User();
		
		boolean result = service.resetPassword(user);
		
		System.out.println("reset password");
		
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new User());

		return mav;
	}*/
	
	
	/*@RequestMapping(value ="/resetpassword",method= RequestMethod.POST)
	public String showLogin() {

		boolean result = service.resetPassword(user);
		
		System.out.println("reset password");
		
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new User());

		return "login";
	}*/
	
}

