package com.cybage;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JUnitApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testAddition() {
		// Assume Calculator.add(a, b) returns the sum of a and b.
//	    int expected = 5;
//	    int actual = Calculator.add(2, 3);
		assertEquals(5, 2 + 3, "2 + 3 should equal 5");
	}

	@Test
	void testSubtraction() {
		// Ensure subtraction does not mistakenly equal an incorrect value.
		int unexpected = 5;
		int actual = Calculator.substract(3, 2);
		assertNotEquals(unexpected, actual, "3 - 2 should not equal 5");
	}

	@Test
	void testListIsEmpty() {
		List<String> list = new ArrayList<>();
		assertTrue(list.isEmpty(), "The list should be empty");
	}

	@Test
	@DisplayName("Test falsy condition")
	void testValues() {
		assertFalse(5 < 3, "5 should not less than 3");
	}

	@Test
	void testInitialStateIsNull() {
		Calculator obj = new Calculator();
		obj = null;
		assertNull(obj, "Optional value should initially be null");
	}

	@Test
	void testServiceReturnsObject() {
		Calculator result = new Calculator();
		assertNotNull(result, "User should not be null");
	}

	@Test
	@DisplayName("Both are same objects")
	void testSingletonInstance() {
		Calculator obj = new Calculator();
		Calculator inst1 = obj;
		System.out.println(inst1);
		Calculator inst2 = obj;
		System.out.println(inst1);

		assertSame(inst1, inst2, "Both instances should be the same");
	}

	@Test
	@DisplayName("Both are differebt objects")
	void testDifferentInstances() {
		String s1 = new String("hello");
		System.out.println(System.identityHashCode(s1));
		String s2 = new String("hello");
		System.out.println(System.identityHashCode(s2));
		assertNotSame(s1, s2, "Different String instances should not be the same object");
	}

	@Test
	@DisplayName("Identify method return correct array.")
	void testArrayContent() {
		int[] expected = { 1, 2, 3, 4, 5 };
		int[] actual = Calculator.getNumbers();
		assertArrayEquals(expected, actual, "The arrays should be equal");
	}

	@Test
	@DisplayName("Identify elements of Interable array are same.")
	void testListContent() {
		List<String> expected = Arrays.asList("one", "two", "three");
		List<String> actual = Calculator.getStringList();
		assertIterableEquals(expected, actual, "The lists should have the same elements in order");
	}

	@Test
	void testDivideByZero() {
		Calculator c = new Calculator();

		assertThrows(ArithmeticException.class, () -> c.divide(5, 0), "Checking division");
	}

	@Test
	void testDivision() {
		Calculator c = new Calculator();

		assertDoesNotThrow(() -> c.divide(5, 5), "Checking division");
	}

	@Test
	void testUserProperties() {
		User user = new User("John", "Doe", 30);
		assertAll("user", 
				() -> assertEquals("John", user.getFirstName(), "First name should be John"),
				() -> assertEquals("Doe", user.getLastName(), "Last name should be Doe"),
				() -> assertTrue(user.getAge() > 18, "Age should be greater than 18"));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"A", "B", "C"})
	public void valueSourceTest(String value) {
		System.out.println(value.getClass().getName());
	    assertNotNull(value);
	}
	
	@ParameterizedTest
	@CsvSource({"1, true", "2, false"})
	public void csvSourceTest(int input, boolean expected) {
	    assertEquals(expected, input == 1);
	}


}

class User {
	String firstName;
	String lastName;
	public User(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	int age;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
