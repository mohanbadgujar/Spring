package com.bridgelabz.service.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.dao.UserDao;
import com.bridgelabz.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao dao;

	public boolean authUser(User user) {

		return dao.authenticateUser(user);

	}

	public Boolean saveuser(User user) {

		return dao.saveUser(user);

	}

	/*
	 * public Object findByUserEmail(String fullName) { return ""; }
	 */

}
