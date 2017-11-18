package com.bridgelabz;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class MySet {

	public static void main(String args[]) throws Exception {

		// TreeSet sort elements
		Set<Integer> list = new HashSet<Integer>();

		// Adding object in arraylist
		list.add(12);
		list.add(85);
		list.add(32);
		list.add(2);

		Set<String> al = new LinkedHashSet<String>();
		al.add("Ravi");
		al.add("Vijay");
		al.add("Ravi");
		al.add("Ajay");
		
		
		Set<String> al1 = new TreeSet<String>();
		al1.add("Ravi");
		al1.add("Vijay");
		al1.add("Ravi");
		al1.add("Ajay");

		/*
		 * //sort element //Collections.sort(list); Collections.reverse(list);
		 */

		/*
		 * Traversing list through Iterator Iterator itr = list.iterator();
		 * 
		 * while (itr.hasNext()) { System.out.println(itr.next()); }
		 */

		// Using for loop
		for (String i : al)
			System.out.println(i);

		/*
		 * //stream api lambda expression list.forEach(System.out::println);
		 */

	}
}
