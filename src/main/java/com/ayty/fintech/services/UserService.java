package com.ayty.fintech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
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
		return new User(objDto.getId(), objDto.getFullName(), objDto.getCpf(), objDto.getPhone(), objDto.getEmail(), objDto.getPassword());
	}
	
	public Consumer fromConsumerDto(ConsumerDTO objDto) {
		return new Consumer(objDto.getId(), objDto.getUser_id(), objDto.getUsername());
	}


	public Page<User> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return userRepository.findAll(pageRequest);
	}
}
