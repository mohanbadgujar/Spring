package com.bridgelabz.controller;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.model.Login;
import com.bridgelabz.model.User;
import com.bridgelabz.service.business.UserService;
import com.bridgelabz.service.utility.SendEmail;
import com.bridgelabz.validator.UserValidation;

@Controller
public class RegistrationController {
	@Autowired
	UserService service;

	/*@Autowired
	SendEmail sendMail;*/

	@RequestMapping(value = "register")
	public ModelAndView showRegister() {

		ModelAndView mv = new ModelAndView("register");
		mv.addObject("user", new User());
		return mv;
		
	}

	@RequestMapping(value = "/regProcess", method = RequestMethod.POST)
	public ModelAndView regProcess(@ModelAttribute("user") User user, BindingResult result) {
		ModelAndView mav = null;
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		UserValidation validation = new UserValidation();
		validation.validate(user, result);
		

		if (!result.hasErrors()) {

			// Encrypt and set password using Java Simplified Encryption
			String encryptedPassword = passwordEncryptor.encryptPassword(user.getPassword());
			user.setPassword(encryptedPassword);
			
			Boolean res = service.saveuser(user);
		

			if (!res) {
				mav = new ModelAndView("register");
				mav.addObject("message", "Something went wrong");
				return mav;
			}

		/*	String staus = sendMail.sendEmail(user);
*/
		/*	System.out.println("status" + staus);*/
			return new ModelAndView("login", "login", new Login());

		}

		return new ModelAndView("register", "register", new User());

	}

}
