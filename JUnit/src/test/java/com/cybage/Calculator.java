package com.cybage;

import java.util.ArrayList;

public class Calculator {

	int ans;

	public int getAns() {
		return ans;
	}

	public void setAns(int ans) {
		this.ans = ans;
	}

	public static int add(int a, int b) {
		return a + b;
	}

	public static int substract(int a, int b) {
		return a - b;
	}

	public static int[] getNumbers() {
		return new int[] { 1, 2, 3, 4, 5 };
	}

	public static ArrayList<String> getStringList() {
		ArrayList<String> arr = new ArrayList<>();
		arr.add("one");
		arr.add("two");
		arr.add("three");

		return arr;
	}

	public  int divide(int a, int b) {
		if (b == 0) {
			throw new ArithmeticException("Divide by zero exception");
		}
		
		return a/b;

	}

}
