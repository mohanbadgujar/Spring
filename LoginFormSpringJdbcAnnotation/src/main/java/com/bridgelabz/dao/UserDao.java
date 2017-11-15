package com.bridgelabz.dao;

import com.bridgelabz.model.User;

public interface UserDao {

	public boolean saveUser(User user);

	public boolean authenticateUser(User user);

}
