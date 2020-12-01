package com.ayty.fintech.dtos;

import java.io.Serializable;

import com.ayty.fintech.domain.Consumer;

public class ConsumerDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer user_id;
	private String username;
	
	public ConsumerDTO() {
	}
	
	public ConsumerDTO(Consumer obj) {
		this.id = obj.getId();
		this.user_id = obj.getId();
		this.username = obj.getUsername();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
