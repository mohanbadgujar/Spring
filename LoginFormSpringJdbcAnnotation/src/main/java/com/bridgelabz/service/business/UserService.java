package com.bridgelabz.service.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.dao.UserDao;
import com.bridgelabz.dao.UserDaoImpl;
import com.bridgelabz.model.User;

@Service
public class UserService {

	@Autowired
	UserDao dao;

	public boolean authUser(User user) {
		
		return dao.authenticateUser(user);
	}

	public Boolean saveuser(User user) {

		return dao.saveUser(user);

	}

	
	 public String findByUserEmail(String email) { 
		 
//		 UserDao dao = new UserDaoImpl();
		 
//		 String value = dao.checkUserAlredyExits(email);
		 boolean value = dao.checkUserAlredyExits(email);
		 System.out.println("value"+value);
		 
		 return ""; 
	}

	public Boolean resetPassword(User user) {
		
		return dao.resetPassword(user);
	}
	 

}
