package com.bridgelabz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.model.User;

@Controller
public class LogoutController {
	
	@RequestMapping(value="logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession(false);
		session.removeAttribute("name");
		session.invalidate();
		
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("login", new User());
		return mv;
		
	}

}
