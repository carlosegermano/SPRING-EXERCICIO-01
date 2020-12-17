package com.ayty.fintech.consumer;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;

import com.ayty.fintech.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Consumer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_id_consumer")
	@SequenceGenerator(name = "sequence_id_consumer", sequenceName = "sequence_consumer")
	private Integer id;
	
	@JsonProperty(value = "user_id")
	private Integer userId;
	
	@Column(unique = true)
	private String username;
	
	@JsonIgnore
	@OneToOne
	@PrimaryKeyJoinColumn(name = "user_consumer_id")
	private User user;


}
