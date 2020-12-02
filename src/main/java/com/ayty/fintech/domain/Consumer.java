package com.ayty.fintech.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Consumer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer userId;
	private String username;
	
	@JsonIgnore
	@OneToOne
	@PrimaryKeyJoinColumn(name = "user_consumer_id")
	private User user;
	
	public Consumer() {
	}
	
	public Consumer(Integer userId, String username) {
		this.userId = userId;
		this.username = username;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
