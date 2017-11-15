package com.bridgelabz.HelloWorldWithAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Samsung {

	@Autowired //It will match the data type with component class and return object
	@Qualifier("mobile") //User to decide which class to be excute of MobileProcessor
	MobileProcessor mp;

	public void name() {

		mp.processorName();

		System.out.println("samsung mohan");
	}
}
