package com.ayty.fintech.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayty.fintech.exceptions.InvalidRequestException;
import com.ayty.fintech.user.User;
import com.ayty.fintech.user.UserServiceImpl;

@Service
public class ConsumerServiceImpl implements ConsumerService {

	@Autowired
	private ConsumerRepository consumerRepository;

	@Autowired
	private UserServiceImpl userService;

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

}
