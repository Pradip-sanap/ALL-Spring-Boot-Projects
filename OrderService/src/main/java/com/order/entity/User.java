package com.order.entity;
 

import brave.internal.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "UserData")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Nullable
	private int userID;
	private String userName;
	private String password;
}
