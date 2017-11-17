package com.bridgelabz;

import java.io.FileNotFoundException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

public class AnnotationExample implements MethodInfo {

	@Override
	@MethodInfo(author = "Pankaj", comments = "Main method", date = "Nov 17 2012", revision = 1)
	public String toString() {
		return "Overriden toString method";
	}

	@Deprecated
	@MethodInfo(comments = "deprecated method", date = "Nov 17 2012")
	public static void oldMethod() {
		System.out.println("old method, don't use it.");
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@MethodInfo(author = "Pankaj", comments = "Main method", date = "Nov 17 2012", revision = 10)
	public static <E> void genericsTest() throws FileNotFoundException {
		List<E> l = new ArrayList<>();
		l.add((E) "abc");
		oldMethod();
	}

	@Override
	public Class<? extends Annotation> annotationType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String author() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String date() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int revision() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String comments() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
