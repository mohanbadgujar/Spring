package com.bridgelabz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Repository;

import com.bridgelabz.model.User;

@Repository("dao")
@Configurable
public class UserDaoImpl implements UserDao {

	private DataSource dataSource;
	Connection con = null;
	StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();

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

			String sql = "select * from User Where email=?";

			// create the statement object
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, user.getEmail());

			ResultSet rs = stmt.executeQuery();

			// check is any data in ResultSet
			while (rs.next()) {

				// Check encrypted and current password
				if (passwordEncryptor.checkPassword(user.getPassword(), rs.getString("password"))) {
					st = true;
				}
				return st;
			}

			// close the connection object
			/* con.close(); */

		} catch (Exception e) {
			e.printStackTrace();
		}
		return st;
	}

	public boolean checkUserAlredyExits(String email) {

		try {

			/*
			 * String myDriver = "com.mysql.jdbc.Driver"; String myUrl =
			 * "jdbc:mysql://localhost:3306/SpringDemo";
			 * 
			 * // Register the driver class Class.forName(myDriver);
			 * 
			 * // Create the connection object Connection con =
			 * DriverManager.getConnection(myUrl, "root", "bridgeit");
			 */

			con = dataSource.getConnection();
			System.out.println("connection");

			String sql = "select * from User Where email=?";

			// create the statement object
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, email);

			ResultSet rs = stmt.executeQuery();
			// check is any data in ResultSet
			while (rs.next()) {
				System.out.println("I Am here");
				rs.getString("email");
				return true;
			}

			// close the connection object
			/*
			 * con.close();
			 */
		} catch (Exception e) {

			System.out.println("Exc");
			e.printStackTrace();
		}

		return true;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	@Override
	public boolean resetPassword(User user) {

		try {

			con = dataSource.getConnection();

			// create the java mysql update preparedstatement
			String query = "update User set password = ? where email = ?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(2, user.getEmail());
			preparedStmt.setString(1, user.getPassword());

			// execute the preparedstatement
			preparedStmt.execute();

			con.close();

			return true;

		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}

		return false;
	}

}
