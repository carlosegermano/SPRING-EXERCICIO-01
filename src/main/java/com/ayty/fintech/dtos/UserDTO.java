package com.ayty.fintech.dtos;

import java.io.Serializable;

import com.ayty.fintech.domain.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@JsonProperty(value = "full_name")
	private String fullName;
	
	private String cpf;
	private String phone;
	private String email;
	private String password;
	
	public UserDTO() {
	}
	
	public UserDTO(User obj) {
		this.id = obj.getId();
		this.fullName = obj.getFullName();
		this.cpf = obj.getCpf();
		this.phone = obj.getPhone();
		this.email = obj.getEmail();
		this.password = obj.getPassword();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
