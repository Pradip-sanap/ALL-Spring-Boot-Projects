package com.junit;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Calculator {

	public int sum(int a, int b) {
		return a + b;
	}

	public int[] doubleTheArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] * 2;
		}
		return arr;
	}

	public Object saveResult(boolean flag) {
		if (!flag) {
			throw new RuntimeException();
		}
		return null;
	}

	public void riskyMethod(boolean flag) {
		if (!flag) {
			throw new RuntimeException("Something went wrong");
		}
	}

	public Object divide(int a, int b) {
		try { 
			return a / b;
		} catch (Exception e) {
			throw new ArithmeticException();
		}
	}

	public static boolean isEmailValid(String email) {
		return (email != null) && (email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$"));
	}
	
	boolean isEven(int num) {
		if(num %2 ==0) {
			return true;
		}
		return false;
	}
	
	int getNumber() {
		return 8;
	}

}
