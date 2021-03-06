package com.bridgelabz.model;

import java.sql.Date;

public class User {

	private String name;
	private String email;
	private String password;
	private String repassword;
	private String mobile;
	private Date birth;
	private String sex;
	
	public User() {}
	
	public User(String name, String email, String password, String repassword, String mobile, Date birth,
			String sex) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.repassword = repassword;
		this.mobile = mobile;
		this.birth = birth;
		this.sex = sex;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

}
