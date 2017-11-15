package com.bridgelabz.HelloWorldWithAnnotation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary //It makes this class is excuted first when MobileProcessor object is to be created
public class Phone implements MobileProcessor {

	public void processorName() {
		
		System.out.println("phone Processor");
		
	}

}
