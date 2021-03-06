package com.bridgelabz.controller;

import java.sql.Date;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bridgelabz.dao.UserDao;
import com.bridgelabz.model.User;
	
public class App {

	public static void main(String args[])
	{
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");

		UserDao userDao = (UserDao) context.getBean("userDAO");
		
		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("Select your choice=");
			System.out.println("1.Register User\n2.Login User\n3.Delete\n4.Display\n5.Update\n6.Exit");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("\nEnter name =");
				String name = sc.next();
				System.out.println("\nEnter email =");
				String email = sc.next();
				System.out.println("\nEnter password =");
				String password = sc.next();
				System.out.println("\nEnter mobile Number =");
				String mobile = sc.next();
				Date date = new Date(10, 11, 1993);
				System.out.println("\nEnter Gender =");
				String gender = sc.next();
				
				User user = new User(name,email,password,password,mobile,date,gender);
				userDao.insert(user);
				System.out.println("Data inserted Successfully");
				break;
				
			case 2:
				
				System.out.println("\nEnter User Name =");
				String uname = sc.next();
				System.out.println("\nEnter Password =");
				String pass = sc.next();
				
				userDao.login(uname,pass);
				
				break;
	
			case 3:
				System.out.println("Enter id number for which you want to delete data=");
				int id = sc.nextInt();
				userDao.delete(id);
				System.out.println("Data Deleted Successfully");
				break;
				
			case 4:
				System.out.println("Your Data");
				userDao.display();
				break;
				
			case 5:
				
				System.out.println("Enter what you want to change \nname\nemail\nmobile=");
				String value = sc.next();
				
				System.out.println("Enter what you want to set =");
				String updateValue = sc.next();
				
				System.out.println("Enter id for which you want change=");
				int id1 =sc.nextInt();
				
				userDao.update(value,updateValue,id1);
				System.out.println("Data Updated Successfully");
				break;
				
			default:
				System.out.println("You are out Successfully");
				System.exit(0);
				break;
			}
		}
	}
}
