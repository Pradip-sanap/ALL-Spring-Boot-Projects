package com.dev.app.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
//@Scope("request")
@Scope("session")
@AllArgsConstructor
@NoArgsConstructor 
public class User {

	int uid;
	String username;
}
