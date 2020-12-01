package com.ayty.fintech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayty.fintech.domain.Consumer;
import com.ayty.fintech.domain.User;
import com.ayty.fintech.dtos.ConsumerDTO;
import com.ayty.fintech.dtos.UserDTO;
import com.ayty.fintech.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public Optional<User> find(Integer id) {
		return userRepository.findById(id);
	}
	
	public User insert(User obj) {
		return userRepository.save(obj);
	}
	
	public Consumer insert(Consumer obj) {
		return userRepository.save(obj);
	}
	
	public User fromUserDto(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getFull_name(), objDto.getCpf(), objDto.getPhone(), objDto.getEmail(), objDto.getPassword());
	}
	
	public Consumer fromConsumerDto(ConsumerDTO objDto) {
		return new Consumer(objDto.getUser_id(), objDto.getUsername());
	}
}
