package com.ayty.fintech.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Seller implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE, 
        generator = "sequence_id_seller"
    )
    @SequenceGenerator(
        name =  "sequence_id_seller",
        sequenceName = "sequence_seller"
    )
	private Integer id;
	private String cnpj;
	private String fantasy_name;
	private String social_name;
	private String username;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "user_seller_id")
	@MapsId
	private User user;
	
	public Seller(Integer id, String full_name, String cpf, String phone, String email, String password, String cnpj,
			String fantasy_name, String social_name, String username) {
		this.id = id;
		this.cnpj = cnpj;
		this.fantasy_name = fantasy_name;
		this.social_name = social_name;
		this.username = username;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seller other = (Seller) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
