package com.bridegelabz.dao;

import com.bridgelabz.model.Login;
import com.bridgelabz.model.User;

public interface UserDao {

	Boolean authUser(Login user);

	Boolean saveUser(User user);

	boolean checkUserAlreadyExits(String email);

}
