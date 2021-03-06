package com.bridgelabz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.bridgelabz.model.User;


public class UserDaoImplementation implements UserDao {

	private DataSource dataSource;
	Connection con = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	/* private Properties prop = null;
	 
	 public UserDaoImplementation(){
         
	        InputStream is = null;
	        try {
	            this.prop = new Properties();
	            is = this.getClass().getResourceAsStream("/config.properties");
	            prop.load(is);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	     
	    public String getPropertyValue(String key){
	        return this.prop.getProperty(key);
	    }*/

		public void insert(User user) {
			
			/*String driver = getPropertyValue("driverClassName");
			String url = getPropertyValue("url");*/
			
			String sql = "insert into User_Details(name, email, password, mobile, birth, sex) values(?,?,?,?,?,?)";
		
			int i = 0;
			
			
			try {

				//Create connection object
				con = dataSource.getConnection();
				
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, user.getName());// 1 specifies the first parameter in the query
				stmt.setString(2, user.getEmail());
				stmt.setString(3, user.getPassword());
				stmt.setString(4, user.getMobile());
				stmt.setDate(5, user.getBirth());
				stmt.setString(6, user.getSex());

				i = stmt.executeUpdate();
				System.out.println(i + " records inserted");

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
					}
				}
			}
		}
			
		
		public void login(String uname, String pass) {
			
			try {

			  con = dataSource.getConnection();

				//step3 : create the statement object  
				Statement stmt = con.createStatement();

				//step4 : execute query  
				String sql = "select * from User_Details Where email='"+uname+"' and password='"+pass+"'";
			
				ResultSet rs = stmt.executeQuery(sql);
			
				//check is any data in ResultSet 
				while(rs.next()) 
				{
					System.out.println("Welcome");
				}
				 
				//step5 : close the connection object 
				con.close();  
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		
		public void delete(int id) {
		
			
			try {

				//Create connection object
				con = dataSource.getConnection();
				
				String query = "delete from User_Details where id = ?";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				preparedStmt.setInt(1, id);

				// execute the PreparedStatement
				preparedStmt.execute();

				con.close();

			} catch (Exception e) {
				System.err.println("Got an exception!");
				System.err.println(e.getMessage());
			}
		}
		
		public void update(String value,String updateValue, int id1) {

			try {

				//Create connection object
				con = dataSource.getConnection();
				
				// Create the java mySql update preparedStatement
				String query = "update User_Details set "+value+" = ? where id = ? ";
			
				PreparedStatement preparedStmt = con.prepareStatement(query);
				preparedStmt.setString(1, updateValue);
				preparedStmt.setInt(2, id1);

				// execute the preparedStatement
				preparedStmt.execute();

				con.close();
				
			} catch (Exception e) {
				System.err.println("Got an exception!");
				System.err.println(e.getMessage());
			}
		}

		public void display() {
			try {

				//Create connection object
				con = dataSource.getConnection();

				// Create the Statement object
				Statement stmt = con.createStatement();

				// Execute the query
				ResultSet rs = stmt.executeQuery("select * from User_Details");

				while (rs.next()) {
					System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
				}

				// Close the connection object
				con.close();

			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
	}

