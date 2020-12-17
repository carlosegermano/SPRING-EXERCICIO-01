package com.ayty.fintech.consumer;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ayty.fintech.user.User;
import com.ayty.fintech.user.UserServiceImpl;

@Controller
@RequestMapping(value = "/api/users/consumers")
public class ConsumerController {
	
	@Autowired
	private ConsumerServiceImpl consumerService;
	
	@Autowired
	private UserServiceImpl userService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ConsumerDTO objDto) {
		Consumer obj = ConsumerDTO.from(objDto);
		obj = consumerService.insert(obj);
		User user = userService.find(obj.getUserId());
		user.setConsumer(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
				.path("/{id}").buildAndExpand(obj.getUserId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
