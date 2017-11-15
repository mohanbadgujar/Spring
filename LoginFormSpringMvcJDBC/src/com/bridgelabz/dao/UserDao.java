package com.bridgelabz.dao;

import com.bridgelabz.model.User;

public interface UserDao {

	public void insert(User user);
	public void login(String uname,String pass);
	public void delete(int id);
	public void update(String value,String updateValue, int id1);
	public void display();
}
