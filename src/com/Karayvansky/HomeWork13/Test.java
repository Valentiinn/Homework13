package com.Karayvansky.HomeWork13;

import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		Iterator randomIterator = list.randomListIterator();
		System.out.println("Random ArrayList:");
		while (randomIterator.hasNext()) {
			System.out.println("Element: " + randomIterator.next());
		}
		System.out.println("Without random " + list.toString());
	}
}
