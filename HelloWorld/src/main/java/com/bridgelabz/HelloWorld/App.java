package com.bridgelabz.HelloWorld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       Employee empobj = (Employee) context.getBean("studbean"); 
       empobj.name();
    }
}
