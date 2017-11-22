package com.bridegelabz.controller;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridegelabz.services.UserServices;
import com.bridgelabz.model.User;
import com.bridgelabz.validator.UserValidation;

@RestController
public class RegistrationController {

	@Autowired
	UserServices userService;

	@Autowired
	UserValidation userValidation;

	@RequestMapping(value = "/registrationProcess", method = RequestMethod.POST)
	public ResponseEntity<String> registration(@RequestBody User user, BindingResult result) {

		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();

		userValidation.validate(user, result);

		if (!result.hasErrors()) {

			// Encrypt and set password using Java Simplified Encryption
			String encryptedPassword = passwordEncryptor.encryptPassword(user.getPassword());
			user.setPassword(encryptedPassword);

			Boolean res = userService.saveUser(user);

			if (!res) {

				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not saved");
			}

			return ResponseEntity.ok("success");

		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not saved");

	}
}
