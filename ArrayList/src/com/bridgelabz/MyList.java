package com.bridgelabz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class MyList {

	public static void main(String args[]) throws Exception {

		// Creating arraylist
		List<Integer> list = new ArrayList<Integer>();

		// Adding object in arraylist
		list.add(12);
		list.add(85);
		list.add(32);
		list.add(2);

		List<Integer> al2 = new ArrayList<Integer>();
		al2.add(50);
		al2.add(100);

		// creating linkedlist
		List<String> linklist = new LinkedList<String>();

		// adding object in linkedlist
		linklist.add("James");
		linklist.add("Serena");
		linklist.add("Swati");
		linklist.add("Junaid");
		

		System.out.println("arraylist: " + list);
		System.out.println("linkedlist: " + al2);
		System.out.println("linkedlist: " + linklist);

		// adding second list in first list
		list.addAll(al2);

		/*
		 * //retaining element list.retainAll(al2);
		 */

		/*
		 * //remove all element list.removeAll(al2);
		 */

		// sort element
		// Collections.sort(list);
		Collections.reverse(list);

		Iterator itr = list.iterator();
		
		/*
		 * System.out.println("traversing elements in forward direction...");  
		 * 
		 * while (itr.hasNext()) { System.out.println(itr.next()); }
		 */

		/*System.out.println("traversing elements in forward direction...");  
		
		while(itr.hasPrevious()){  
			System.out.println(itr.previous());  
			}  */
		
		
		/*
		 * // Using for loop for (int i : list) System.out.println(i);
		 */

		/*
		 * //stream api lambda expression list.forEach(System.out::println);
		 */

	}
}
