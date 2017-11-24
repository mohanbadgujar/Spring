package com.bridegelabz.services;

import org.hibernate.HibernateException;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bridegelabz.dao.UserDao;
import com.bridegelabz.util.SendEmail;
import com.bridegelabz.util.TokenGenerator;
import com.bridgelabz.model.User;

public class UserServices {

	@Autowired
	private UserDao userDao;

	@Autowired
	private SendEmail sendMail;

	StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();

	@Transactional
	public void saveUser(User user, String url) throws HibernateException {

		// Encrypt and set password using Java Simplified Encryption
		String encryptedPassword = passwordEncryptor.encryptPassword(user.getPassword());
		user.setPassword(encryptedPassword);

		try {
			userDao.saveUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String accessToken = TokenGenerator.generate(user.getId());
		url = url.substring(0, url.lastIndexOf("/")) + "/" + "activate" + "/" + accessToken;
		sendMail.sendRegistrationMail(user.getEmail(), url);
	}

	public String authenticateUser(String email, String password) {

		User fromDB = userDao.getUserByEmailId(email);
		String token = null;
		if (fromDB != null && fromDB.getEmail().equals(email)
				&& passwordEncryptor.checkPassword(password, fromDB.getPassword())) {
			token = TokenGenerator.generate(fromDB.getId());
			return token;
		}
		return token;
	}

	public User getUserByEmailId(String email) {

		return userDao.getUserByEmailId(email);
	}
	@Transactional
	public User getUserById(int id) {

		return userDao.getUserById(id);
	}

	@Transactional
	public boolean updateUser(int id) {
		User user = userDao.getUserById(id);
		user.setActive(true);
		return userDao.updateUser(user);
	}

	//for forgot password
	@Transactional
	public boolean updateUser(int id, String password) {
		User user = userDao.getUserById(id);
		String encryptedPassword = passwordEncryptor.encryptPassword(user.getPassword());
		user.setPassword(encryptedPassword);
		return userDao.updateUser(user);
	}

}
