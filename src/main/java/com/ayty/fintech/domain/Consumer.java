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
public class Consumer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE, 
        generator = "sequence_id_consumer"
    )
    @SequenceGenerator(
        name =  "sequence_id_consumer",
        sequenceName = "sequence_consumer"
    )
	private Integer id;

	private String username;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "user_id")
	@MapsId
	private User user;
	
	public Consumer() {
	}
	
	public Consumer(Integer id, String username) {
		this.id = id;
		this.username = username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		Consumer other = (Consumer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
