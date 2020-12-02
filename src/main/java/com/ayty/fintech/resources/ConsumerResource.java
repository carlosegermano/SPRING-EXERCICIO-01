package com.ayty.fintech.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ayty.fintech.domain.Consumer;
import com.ayty.fintech.domain.User;
import com.ayty.fintech.dtos.ConsumerDTO;
import com.ayty.fintech.services.ConsumerService;
import com.ayty.fintech.services.UserService;

@Controller
@RequestMapping(value = "/api/consumers")
public class ConsumerResource {
	
	@Autowired
	private ConsumerService consumerService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ConsumerDTO objDto) {
		Consumer obj = consumerService.fromDto(objDto);
		obj = consumerService.insert(obj);
		User user = userService.find(obj.getUserId()).get();
		user.setConsumer(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
				.path("/{id}").buildAndExpand(obj.getUserId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
