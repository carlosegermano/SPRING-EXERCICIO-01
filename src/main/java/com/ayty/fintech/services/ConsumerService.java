package com.ayty.fintech.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayty.fintech.domain.Consumer;
import com.ayty.fintech.domain.User;
import com.ayty.fintech.dtos.ConsumerDTO;
import com.ayty.fintech.repositories.ConsumerRepository;
import com.ayty.fintech.services.exceptions.InvalidRequestException;

@Service
public class ConsumerService {

	@Autowired
	private ConsumerRepository consumerRepository;
	
	@Autowired
	private UserService userService;
	
	public Consumer insert(Consumer obj) {
		
		User user = userService.find(obj.getUserId());
		
		if (user.getConsumer() == null) {
			obj = consumerRepository.save(obj);
			user.setConsumer(obj);
			userService.update(user);
			return obj;
		}
		
		throw new InvalidRequestException("Invalid Request!");
		
	}
	
	public Consumer fromDto(ConsumerDTO objDto) {
		return new Consumer(objDto.getId(), objDto.getUserId(), objDto.getUsername());
	}
}
