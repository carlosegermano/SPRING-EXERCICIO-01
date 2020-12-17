package com.ayty.fintech.consumer;

import java.io.Serializable;

public class ConsumerDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer userId;
	private String username;
	
	public ConsumerDTO() {
	}
	
	public ConsumerDTO(Consumer obj) {
		this.id  = obj.getId();
		this.userId = obj.getUserId();
		this.username = obj.getUsername();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	public static Consumer from(ConsumerDTO objDto) {
		Consumer obj = new Consumer();
		obj.setId(objDto.getId());
		obj.setUserId(objDto.getUserId());
		obj.setUsername(objDto.getUsername());
		return obj;
	}
	
	public static ConsumerDTO to(Consumer obj) {
		ConsumerDTO objDto = new ConsumerDTO();
		objDto.setId(obj.getId());
		objDto.setUserId(obj.getUserId());
		objDto.setUsername(obj.getUsername());
		return objDto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsumerDTO other = (ConsumerDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
