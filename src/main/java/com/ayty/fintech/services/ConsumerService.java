package com.ayty.fintech.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayty.fintech.domain.Consumer;
import com.ayty.fintech.dtos.ConsumerDTO;
import com.ayty.fintech.repositories.ConsumerRepository;

@Service
public class ConsumerService {

	@Autowired
	private ConsumerRepository consumerRepository;
	
	public Consumer insert(Consumer obj) {
		return consumerRepository.save(obj);
	}
	
	public Consumer fromDto(ConsumerDTO objDto) {
		return new Consumer(objDto.getUser_id(), objDto.getUsername());
	}
}
