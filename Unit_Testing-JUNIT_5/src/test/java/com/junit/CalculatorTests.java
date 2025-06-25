package com.junit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

//import static org.junit.jupiter.api.

public class CalculatorTests {

	Calculator c;

	@BeforeEach
	void initialization() {
		c = new Calculator();
	}

	@Test
	void twoPlusTwoShouldEqualFour() {
		Calculator c = new Calculator();
		int sum = c.sum(2, 2);
		assertEquals(4, sum, "2+2 should equals 4");
		assertNotEquals(7, sum);

		assertTrue(sum > 2);
		assertFalse(sum > 6);

		Calculator c2 = null;
		assertNull(c2);

		Calculator c3 = new Calculator();
		assertNotNull(c3);

		Calculator obj1 = c3;
		Calculator obj2 = c3;
		Calculator obj3 = c;

		assertSame(obj1, obj2, "both object must be same");
		assertNotSame(obj1, obj3, "both object must be same");

		assertThrows(RuntimeException.class, () -> c.riskyMethod(false));
		assertDoesNotThrow(() -> c.riskyMethod(true));

	}

	@Test
	void arrayElementsShouldDouble() {
		int[] actual = { 1, 2, 3, 4 };
		int[] expected1 = { 2, 4, 6, 8 };

		int[] result = c.doubleTheArray(actual);

		assertArrayEquals(actual, expected1);

	}

	@Test
	void divideByZeroShouldThrowsException() {
		assertDoesNotThrow(() -> c.divide(10, 5), "Expect this method not throw error but it throws error");
		assertThrows(ArithmeticException.class, () -> c.divide(10, 0));
	}

	@Test
	void testPersonDetails() {
		Person person = new Person("John", 30);

		assertAll("person", 
				() -> assertEquals("John4", person.getName()), 
				() -> assertEquals(30, person.getAge()),
				() -> assertTrue(person.getAge() > 0));
	}

}
 
class Person {
	String name;
	int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	String getName() {
		return name;
	}

	int getAge() {
		return age;
	}
}
