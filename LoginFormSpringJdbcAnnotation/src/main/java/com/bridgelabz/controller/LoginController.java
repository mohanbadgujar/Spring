package com.bridgelabz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.model.Login;
import com.bridgelabz.model.User;
import com.bridgelabz.service.business.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService service;

	@RequestMapping(value = "/login")
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new User());

		return mav;
	}

	/*@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(@ModelAttribute("login") User user, HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView mav = null;

		Boolean userValide = service.authUser(user);

		if (!userValide) {

			mav = new ModelAndView("/login");
			mav.addObject("message", "Username or Password is wrong!!");

			return mav;
		}

		HttpSession session = request.getSession();

		session.setAttribute("name", user.getEmail());

		mav = new ModelAndView("redirect:/welcome");

		return mav;

	}*/
	
	@ResponseBody
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ResponseEntity<String> loginProcess(@RequestBody Login user, HttpServletRequest request,
			HttpServletResponse response) {

		Boolean userValide = service.authUser(user);

		if (!userValide) {

			String res_msg = "User name and password wrong";
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res_msg);
		}

		HttpSession session = request.getSession();

		session.setAttribute("name", user.getEmail());

		return ResponseEntity.ok("success");

	}
}
