package com.bridgelabz.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bridgelabz.model.User;
import com.bridgelabz.service.business.UserService;

public class UserValidation implements Validator {

	/*
	 * @Autowired private UserService service;
	 */

	public boolean supports(Class<?> clazz) {
		return false;
	}

	public void validate(Object object, Errors errors) {

		UserService service = new UserService();

		User user = (User) object;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty");

		if (user.getFullName().length() < 3 || user.getFullName().length() > 16) {
			errors.rejectValue("fullName", "Size.regForm.fullName");
		}

	/*	if (service.findByUserEmail(user.getEmail()) != null) {
			errors.rejectValue("email", "Duplicate.regForm.email");
		}*/
		
		Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
	            Pattern.CASE_INSENSITIVE);
	      if (!(pattern.matcher(user.getEmail()).matches())) {
	    	  errors.rejectValue("email", "user.email.invalid");
	      }

		if (user.getPassword().length() < 6 || user.getPassword().length() > 16) {
			errors.rejectValue("password", "Size.regForm.password");
		}

		if (user.getPhone().length() < 10 || user.getPassword().length() > 10) {
			errors.rejectValue("phone", "Size.regForm.phone");
		}
	}
}
