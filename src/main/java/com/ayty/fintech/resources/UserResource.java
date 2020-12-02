package com.ayty.fintech.resources;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ayty.fintech.domain.User;
import com.ayty.fintech.dtos.UserDTO;
import com.ayty.fintech.dtos.UserUpdateDTO;
import com.ayty.fintech.services.UserService;

@RestController
@RequestMapping(value = "/api/users")
public class UserResource {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = userService.findAll();
		List<UserDTO> listDto = list.stream().map(obj -> new UserDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<User> find(@PathVariable Integer id) {
		User obj = userService.find(id).get();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/name", method=RequestMethod.GET)
	public ResponseEntity<List<User>> find(@RequestParam(value="value") String name){
		List<User> obj = userService.findByFullNameContainingIgnoreCase(name);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/page", method=RequestMethod.GET)
	public ResponseEntity<Page<UserDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "fullName") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<User> list = userService.findPage(page, linesPerPage, orderBy, direction);
		Page<UserDTO> listDto = list.map(obj -> new UserDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody UserDTO objDto) {
		User obj = userService.fromDto(objDto);
		obj = userService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody UserUpdateDTO objDto, @PathVariable Integer id) {
		User obj = userService.fromDto(objDto);
		obj.setId(id);
		obj = userService.update(obj);
		return ResponseEntity.noContent().build();
	}
}
