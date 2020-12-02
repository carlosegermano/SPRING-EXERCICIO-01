package com.ayty.fintech.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Seller implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_id_seller")
	@SequenceGenerator(name = "sequence_id_seller", sequenceName = "sequence_seller")
	private Integer id;
	
	private String cnpj;
	
	@JsonProperty(value = "fantasy_name")
	private String fantasyName;
	
	@JsonProperty(value = "social_name")
	private String socialName;
	
	private String username;
	
	@JsonProperty(value = "user_id")
	private Integer userId;

	@JsonIgnore
	@OneToOne
	@PrimaryKeyJoinColumn(name = "user_seller_id")
	private User user;
	
	public Seller() {
	}
	
	public Seller(Integer id, Integer userId, String cnpj,
			String fantasyName, String socialName, String username) {
		this.id = id;
		this.userId = userId;
		this.cnpj = cnpj;
		this.fantasyName = fantasyName;
		this.socialName = socialName;
		this.username = username;
	}
	
	public void setId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getId() {
		return id;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getFantasyName() {
		return fantasyName;
	}
	
	public void setFantasyName(String fantasyName) {
		this.fantasyName = fantasyName;
	}
	
	public String getSocialName() {
		return socialName;
	}
	
	public void setSocialName(String socialName) {
		this.socialName = socialName;
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
