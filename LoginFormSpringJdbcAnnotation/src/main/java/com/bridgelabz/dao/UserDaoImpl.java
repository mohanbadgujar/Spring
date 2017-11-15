package com.bridgelabz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.DataSource;

import com.bridgelabz.model.User;

public class UserDaoImpl implements UserDao {

	private DataSource dataSource;
	Connection con = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public boolean saveUser(User user) {

		Boolean isuserSaved = false;

		int i = 0;

		try {

			// Create connection object
			con = dataSource.getConnection();

			PreparedStatement stmt = con
					.prepareStatement("insert into User(name, email, password, address, phone) values(?,?,?,?,?)");
			stmt.setString(1, user.getFullName());// 1 specifies the first parameter in the query
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getAddress());
			stmt.setString(5, user.getPhone());

			i = stmt.executeUpdate();
			System.out.println(i + " records inserted");

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (i > 0) {
			isuserSaved = true;
		} else {
			isuserSaved = false;
		}

		return isuserSaved;
	}

	public boolean authenticateUser(User user) {

		boolean st = false;
		try {

			// Create connection object
			con = dataSource.getConnection();

			// step3 : create the statement object
			Statement stmt = con.createStatement();

			// step4 : execute query
			String sql = "select * from User Where email='" + user.getEmail() + "' and password='" + user.getPassword()
					+ "'";

			ResultSet rs = stmt.executeQuery(sql);

			// check is any data in ResultSet
			while (rs.next()) {
				st = true;
				return st;
			}

			// step5 : close the connection object
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return st;
	}

}
