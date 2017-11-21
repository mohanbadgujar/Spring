package com.bridegelabz.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.bridegelabz.dao.UserDao;
import com.bridgelabz.model.Login;

public class UserServices {

	@Autowired
	UserDao userDao; 
	
	public Boolean authUser(Login user) {
		
		return userDao.authUser(user);
	}

}
