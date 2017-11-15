package com.bridgelabz.HelloWorldWithAnnotation;

import org.springframework.stereotype.Component;

@Component
public class Mobile implements MobileProcessor {

	public void processorName() {
		System.out.println("Mobile Processor");

	}

}
