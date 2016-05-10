package com.Karayvansky.HomeWork13;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class ArrayList implements List {

	private static final int INITIAL_CAPACITY = 10;

	private String[] array;

	private int size;

	ArrayList() {
		this(INITIAL_CAPACITY);
		// array = new String[INITIAL_CAPACITY];
		// size = 0;
	}

	ArrayList(int capacity) {
		array = new String[capacity];
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}

		return false;
	}

	public boolean contains(String element) {
		for (int i = 0; i < size; i++) {
			if (array[i].equals(element)) {
				return true;
			}
		}
		return false;
	}

	public void add(String element) {
		resize();
		array[size] = element;
		size++;
	}

	private void resize() {
		if (size == array.length) {
			String[] arrayNew = new String[array.length * 2];
			for (int i = 0; i < size; i++) {
				arrayNew[i] = array[i];
			}
			array = arrayNew;
		}

		if (size < 0.25 * array.length) {
			String[] arrayNew = new String[array.length / 2];
			for (int i = 0; i < size; i++) {
				arrayNew[i] = array[i];
			}
			array = arrayNew;
		}
	}

	public String set(int index, String element) {
		String oldElement = array[index];
		array[index] = element;
		return oldElement;
	}

	public void remove(int index) {
		for (int i = index; i < size; i++) {
			array[i] = array[i + 1];
		}
		array[size] = null;
		size--;
		resize();
	}

	public void remove(String element) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(element))
				remove(i);
		}
	}

	public void clear() {
		for (int i = 0; i < array.length; i++) {
			array[i] = null;
			size = 0;
		}
	}

	public int indexOf(String element) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}

	public String get(int index) {
		return array[index];
	}

	public String toString() {
		String elements = "[ ";
		for (int i = 0; i < size; i++) {
			elements += array[i];
			if (i != size - 1) {
				elements += ", ";
			}
		}
		elements += " ]";
		return elements;
	}

	public Iterator listIterator() {
		return new ListIterator();
	}

	public Iterator backwardIterator() {
		return new BackwardListIterator(array, size);
	}

	public Iterator randomListIterator() {
		return new RandomIterator();
	}

	private class ListIterator implements Iterator {

		private int current = 0;

		public boolean hasNext() {
			if (current > size) {
				return false;
			}

			return true;
		}

		public Object next() {
			String element = array[current];
			current++;
			return element;
		}
	}

	private class RandomIterator implements Iterator {
		private Random random = new Random();
		private String[] arrayStir = Arrays.copyOf(array, size);
		private int current = 0;

		RandomIterator() {
			for (int i = 0; i < size - 2; i++) {
				int j = random.nextInt(size - i);
				String temp = arrayStir[i];
				arrayStir[i] = arrayStir[i + j];
				arrayStir[i + j] = temp;
			}
		}

		public boolean hasNext() {
			return current < size;
		}

		public Object next() {
			String element = arrayStir[current];
			current++;
			return element;
		}
	}

}