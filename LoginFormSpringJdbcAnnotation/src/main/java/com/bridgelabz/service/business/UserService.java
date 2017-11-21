package com.bridgelabz.service.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.dao.UserDao;
import com.bridgelabz.model.Login;
import com.bridgelabz.model.User;

@Service
public class UserService {

	@Autowired
	UserDao dao;

	public boolean authUser(Login user) {

		return dao.authenticateUser(user);
	}

	public Boolean saveuser(User user) {

		return dao.saveUser(user);

	}

	public boolean checkUserAlreadyExits(String email) {

		return dao.checkUserAlredyExits(email);
	}

	public Boolean resetPassword(User user) {

		return dao.resetPassword(user);
	}

}
