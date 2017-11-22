package com.bridegelabz.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.bridegelabz.dao.UserDao;
import com.bridgelabz.model.Login;
import com.bridgelabz.model.User;

public class UserServices {

	@Autowired
	UserDao userDao; 
	
	public Boolean authUser(Login user) {
		
		return userDao.authUser(user);
	}

	public Boolean saveUser(User user) {
		
		return userDao.saveUser(user);
	}

	public boolean checkUserAlreadyExits(String email) {
		
		return userDao.checkUserAlreadyExits(email);
	}

}
