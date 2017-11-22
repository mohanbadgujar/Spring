package com.bridegelabz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridegelabz.services.UserServices;
import com.bridgelabz.model.Login;

@RestController
public class LoginController {

	@Autowired
	UserServices userService;

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ResponseEntity<String> loginProcess(@RequestBody Login user, HttpServletRequest request,
			HttpServletResponse response) {

		Boolean userValide = userService.authUser(user);

		if (!userValide) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User name and password wrong");
		}

		HttpSession session = request.getSession();

		session.setAttribute("name", user.getEmail());

		return ResponseEntity.ok("success");

	}
}
