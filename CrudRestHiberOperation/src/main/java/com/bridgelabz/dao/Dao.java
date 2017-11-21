package com.bridgelabz.dao;

import java.util.List;

import com.bridgelabz.model.User;

public interface Dao {

	User findById(int id);

	void SaveUser(User user);

	/* User findByName(String user); */

	void updateUser(User user);

	void deleteUserById(int id);

	List<User> findAllUsers();

}
