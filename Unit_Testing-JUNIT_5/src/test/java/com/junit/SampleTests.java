package com.junit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SampleTests {
	
	Calculator c ;
	
	
	@BeforeEach
	void beforeEach() {
		System.out.println("Before each");
		c = new Calculator();
	}
	
//	@BeforeAll
//	static void  beforeAll() {
//		System.out.println("Before all");
//		
//	}
	
//	@AfterEach
//	void afterEach() {
//		System.out.println("After each");
//	}
	
//	@AfterAll
//	static void afterAll() {
//		System.out.println("After all");
//	}
	
	@Test
	@DisplayName("This is first test. zingat")
	@Tag("slow")
	void Test1() {
		System.out.println("Inside Test1");
	}
	
	@Test
	@Tag("fast")
//	@Disabled("This test case is pending.")
	void Test2() {
		System.out.println("Inside Test2");
	}
	
	@Test
	@RepeatedTest(1)
	void Test3() {
		System.out.println("Inside Test3");
	}
	
	@ParameterizedTest
    @ValueSource(strings = {
        "user@example.com",
        "user.name@domain.co",
        "user_name@sub.domain.org",
        "name123@domain.in"
    })
    void testValidEmails(String email) {
		System.out.println("Valid email chech: " + email);
        assertTrue(Calculator.isEmailValid(email), "Should be valid: " + email);
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "plainaddress",
        "@missingusername.com",
        "user@.com",
        "user@com",
        "user@domain..com"
    })
    void testInvalidEmails(String email) {
    	System.out.println("InValid email chech: " + email);
        assertFalse(Calculator.isEmailValid(email), "Should be invalid: " + email);
    }
    
    @ParameterizedTest
    @ValueSource(ints =  {2, 4, 6, 8})
//    @ValueSource(ints =  {2, 4, 6, 8, 9})
    void shouldReturnTrueWhenEvenNumber(int num) {
    	assertTrue(c.isEven(num));
    }
    
    @Test
    @Timeout(5)
    void timeoutTest() throws InterruptedException {
//    	Thread.sleep(6000);
    	Thread.sleep(4000);
    }
    
    @ParameterizedTest
    @CsvSource({"1, true, a" , "2, false, b"})
    void checkValues(int a, boolean flag, char ch) {
    	System.out.println(a + " " + flag + " " + ch);
    	
//    	Assertions.assertThat()
//    	assertThat("Hello")
//    	assertThat(22).
    	
    }
    
    @Test
    void test5() {
    	int[] arr = {1, 2, 3, 4};
    	assertThat(arr).contains(8);
    	
    	assertThat(c.getNumber()).isGreaterThan(0);
    }

}
