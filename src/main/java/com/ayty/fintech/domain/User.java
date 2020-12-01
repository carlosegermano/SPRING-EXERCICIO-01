package com.ayty.fintech.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;

@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE, 
        generator = "sequence_id_user"
    )
    @SequenceGenerator(
        name =  "sequence_id_user",
        sequenceName = "sequence_user"
    )
	private Integer id;
	
	private String full_name;
	
	@Column(unique = true)
	private String cpf;
	
	private String phone;
	
	@Column(unique = true)
	private String email;
	
	private String password;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Consumer consumer;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Seller seller;
	
	public User() {
	}
	
	public User(Integer id, String full_name, String cpf, String phone, String email, String password) {
		super();
		this.id = id;
		this.full_name = full_name;
		this.cpf = cpf;
		this.phone = phone;
		this.email = email;
		this.password = password;
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

	public void setPassword(String senha) {
		this.password = senha;
	}
	
	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
