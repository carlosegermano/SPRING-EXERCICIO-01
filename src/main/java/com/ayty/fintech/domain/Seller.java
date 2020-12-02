package com.ayty.fintech.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Seller implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer userId;
	private String cnpj;
	private String fantasy_name;
	private String social_name;
	private String username;

	@JsonIgnore
	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;
	
	public Seller(Integer userId, String full_name, String cpf, String phone, String email, String password, String cnpj,
			String fantasy_name, String social_name, String username) {
		this.userId = userId;
		this.cnpj = cnpj;
		this.fantasy_name = fantasy_name;
		this.social_name = social_name;
		this.username = username;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setId(Integer userId) {
		this.userId = userId;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getFantasy_name() {
		return fantasy_name;
	}
	
	public void setFantasy_name(String fantasyName) {
		this.fantasy_name = fantasyName;
	}
	
	public String getSocial_name() {
		return social_name;
	}
	
	public void setSocial_name(String socialName) {
		this.social_name = socialName;
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
