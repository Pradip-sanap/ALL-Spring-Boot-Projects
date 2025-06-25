package com.junit.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.junit.model.User;
import com.junit.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

	@Mock
	UserRepository userRepository;

	@Mock
	EmailService emailService;

	@InjectMocks
	UserService userService;

	User user;

	@BeforeEach
	void initialization() {
		user = new User(11L, "Ronaldo", "cr7@gmail.com");
	}

	@AfterEach
	void termination() {
		user = null;
	}

	@Test
	void registerUserWhenEmailNotAlreadyPresent() {
//		userService.registerUser(user);
//		
//		when(userRepository.existsByEmail("cr7@gmail.com")).thenReturn(true);
//		
//		verify(userRepository).existsByEmail("cr7@gmail.com");
//		User savedUser = verify(userRepository).save(user);
//		 
//		assertEquals(user.getName(), savedUser.getName());
//		Assertions.assertThat(savedUser).isNotNull();
		
		// Arrange
	    when(userRepository.existsByEmail("cr7@gmail.com")).thenReturn(false);
	    when(userRepository.save(user)).thenReturn(user);  // Stub save to return the same user

	    // Act
	    User savedUser = userService.registerUser(user);

	    // Assert
	    verify(userRepository, times(1)).existsByEmail(eq("cr7@gmail.com"));
	    verify(userRepository).save(user);
	    
	    assertEquals(user.getName(), savedUser.getName());
	    Assertions.assertThat(savedUser).isNotNull();
	}

	@Test
	void shouldThrowExceptionWhenEmailAlreadyExists() {
		User user = new User(null, "John", "john@example.com");

		when(userRepository.existsByEmail(user.getEmail())).thenReturn(true);
		

		assertThatThrownBy(() -> userService.registerUser(user)).isInstanceOf(IllegalArgumentException.class)
				.hasMessage("Email already registered");

//		verify(userRepository, never()).();
	}

	// ---------------------
	@Captor
	ArgumentCaptor<String> toCaptor;

	@Captor
	ArgumentCaptor<String> subjectCaptor;

	@Captor
	ArgumentCaptor<String> bodyCaptor;

	@Test
	void captureMultipleArguments() {
		userService.sendEmail("user@example.com", "Hello", "Welcome!");
		verify(emailService).send(toCaptor.capture(), subjectCaptor.capture(), bodyCaptor.capture());

		assertThat(toCaptor.getValue()).isEqualTo("user@example.com");
		assertThat(subjectCaptor.getValue()).isEqualTo("Hello");
		assertThat(bodyCaptor.getValue()).isEqualTo("Welcome!");
	}

}
