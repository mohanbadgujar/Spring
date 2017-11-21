package com.bridgelabz.service.utility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bridgelabz.model.User;
import com.bridgelabz.service.business.UserService;

@Controller
public class ResetPassword {

	@Autowired
	UserService service;
	
	@ResponseBody
	@RequestMapping(value ="newPassword/{email}/resetpassword",method= RequestMethod.POST)
	public String showLogin(@PathVariable String email,HttpServletRequest req, HttpServletResponse res) {
		
		User user = new User();
		user.setEmail(email);
		user.setPassword(req.getParameter("txtPass"));
	
		// Encrypt and set password using Java Simplified Encryption
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		
		String encryptedPassword = passwordEncryptor.encryptPassword(user.getPassword());
		user.setPassword(encryptedPassword);
	
		boolean result = service.resetPassword(user);
		
		if(!result) 
		System.out.println("Your email is not exits");
	
	/*	ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new User());
		return mav;*/
		
		return "redirect:http://localhost:8080/LoginFormSpringJdbcAnnotation/login";
	}
}
