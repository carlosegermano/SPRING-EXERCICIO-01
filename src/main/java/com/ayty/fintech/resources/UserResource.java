package com.ayty.fintech.resources;


import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ayty.fintech.domain.Consumer;
import com.ayty.fintech.domain.User;
import com.ayty.fintech.dtos.ConsumerDTO;
import com.ayty.fintech.dtos.UserDTO;
import com.ayty.fintech.services.UserService;

@RestController
@RequestMapping(value = "api/users")
public class UserResource {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<User> findAll() {
		return userService.findAll();
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<User> find(@PathVariable Integer id) {
		User obj = userService.find(id).get();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody UserDTO objDto) {
		User obj = userService.fromUserDto(objDto);
		obj = userService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/consumers", method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ConsumerDTO objDto) {
		Consumer obj = userService.fromConsumerDto(objDto);
		obj = userService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
