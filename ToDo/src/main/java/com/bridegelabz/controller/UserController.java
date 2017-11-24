package com.bridegelabz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridegelabz.jsonResponse.Response;
import com.bridegelabz.jsonResponse.UserErrorResponse;
import com.bridegelabz.services.UserServices;
import com.bridegelabz.util.SendEmail;
import com.bridegelabz.util.TokenGenerator;
import com.bridegelabz.util.VerifyJwt;
import com.bridgelabz.model.Login;
import com.bridgelabz.model.User;
import com.bridgelabz.validator.UserValidation;

@RestController
public class UserController {

	@Autowired
	private UserServices userService;

	@Autowired
	private UserValidation userValidation;

	@Autowired
	private SendEmail sendMail;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<Response> registration(@RequestBody User user, BindingResult result,
			HttpServletRequest request) {

		Response resp = new Response();
		userValidation.validate(user, result);
		String url = request.getRequestURL().toString();

		if (!result.hasErrors()) {

			try {

				userService.saveUser(user, url);

			} catch (Exception e) {

				e.printStackTrace();
				resp.setStatus(-1);
				resp.setMsg(e.getMessage());
				return new ResponseEntity<Response>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			resp.setStatus(1);
			resp.setMsg("User register sucessfully");
			return new ResponseEntity<Response>(resp, HttpStatus.OK);

		}

		UserErrorResponse err = new UserErrorResponse();
		// err.setErrList(result.getFieldErrors());
		err.setStatus(-1);
		err.setMsg("Invalid Details");
		return new ResponseEntity<Response>(err, HttpStatus.NOT_ACCEPTABLE);

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Response> login(@RequestBody Login login, HttpServletRequest request,
			HttpServletResponse response) {
		Response resp = new Response();
		String jwtToken = userService.authenticateUser(login.getEmail(), login.getPassword());

		if (jwtToken == null) {
			resp.setStatus(-1);
			resp.setMsg("invalid user credential, user not present");
			return new ResponseEntity<Response>(resp, HttpStatus.NOT_ACCEPTABLE);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.add("jwt", jwtToken);

		resp.setStatus(1);
		resp.setMsg("User is Authorized");
		ResponseEntity<Response> entity = new ResponseEntity<Response>(resp, headers, HttpStatus.OK);

		return entity;
		
	}

	@RequestMapping(value = "/activate/{token:.+}")
	public ResponseEntity<String> tokenActivation(@PathVariable("token") String token, HttpServletRequest request,
			HttpServletResponse response) {

		int id = VerifyJwt.verify(token);

		if (id < 0)

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Problem Occured");

		try {

			userService.updateUser(id);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return ResponseEntity.ok("success");
	}
	
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
	public ResponseEntity<String> forgotProcess(@RequestBody User user, HttpServletRequest request,
			HttpServletResponse response) {

		User updatedUser = userService.getUserByEmailId(user.getEmail());

		if (updatedUser == null)
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Enter a valid Email");

		String accessToken = TokenGenerator.generate(updatedUser.getId());

		sendMail.sendForgotMail(user.getEmail(), accessToken);

		return ResponseEntity.ok("success");
	}

	@RequestMapping(value = "/resetPassword/{token:.+}", method = RequestMethod.POST)
	public ResponseEntity<String> resetPassword(@PathVariable("token") String token, @RequestBody User user,
			HttpServletRequest request, HttpServletResponse response) {
	
		int id = VerifyJwt.verify(token);

		try {
			
			userService.updateUser(id, user.getPassword());
			return ResponseEntity.ok("success");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Password not reset");
	}
}
