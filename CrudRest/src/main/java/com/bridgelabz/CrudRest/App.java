package com.bridgelabz.CrudRest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        
    	System.out.println( "Hello World!" );
        ApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class);
       /* Samsung samsung = context.getBean(Samsung.class);
        samsung.name();*/
    }
}
