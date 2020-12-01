package com.ayty.fintech.dtos;

import java.io.Serializable;

import com.ayty.fintech.domain.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String full_name;
	private String cpf;
	private String phone;
	private String email;
	private String password;
	
	public UserDTO() {
	}
	
	public UserDTO(User obj) {
		this.id = obj.getId();
		this.full_name = obj.getFull_name();
		this.cpf = obj.getCpf();
		this.phone = obj.getPhone();
		this.password = obj.getPassword();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
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
