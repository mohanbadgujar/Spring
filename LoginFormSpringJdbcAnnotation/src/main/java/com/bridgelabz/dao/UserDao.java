package com.bridgelabz.dao;

import com.bridgelabz.model.Login;
import com.bridgelabz.model.User;

public interface UserDao {

	public boolean saveUser(User user);

	public boolean authenticateUser(Login user);

	public boolean checkUserAlredyExits(String email);

	public boolean resetPassword(User user);
}
