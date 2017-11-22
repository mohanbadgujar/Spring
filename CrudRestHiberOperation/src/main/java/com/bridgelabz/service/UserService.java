package com.bridgelabz.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bridgelabz.dao.Dao;
import com.bridgelabz.model.User;

public class UserService {

	@Autowired
	Dao userDao;

	public User findById(int id) {
		return userDao.findById(id);
	}

	public void saveUser(User user) {
		userDao.SaveUser(user);
	}
	
	public User findByName(String name) { 
		return userDao.findByName(name);
	}
	 
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	public void deleteUserById(int id) {
		userDao.deleteUserById(id);
	}

	public java.util.List<User> findAllUsers() {
		return userDao.findAllUsers();
	}
}
