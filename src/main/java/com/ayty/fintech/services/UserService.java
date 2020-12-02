package com.ayty.fintech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ayty.fintech.domain.User;
import com.ayty.fintech.dtos.UserDTO;
import com.ayty.fintech.dtos.UserUpdateDTO;
import com.ayty.fintech.repositories.UserRepository;
import com.ayty.fintech.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User find(Integer id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"O objeto não foi encontrado! Id: " + id + ", Tipo: " + User.class.getName()));
	}
	
	public List<User> findByFullNameContainingIgnoreCase(String name){
		return userRepository.findByFullNameContainingIgnoreCase(name);
	}
	
	public User insert(User obj) {
		obj.setId(null);
		return userRepository.save(obj);
	}
	
	public User update(User obj) {
		User newObj = find(obj.getId());
		updateObj(newObj, obj);
		return userRepository.save(newObj);
	}
	
	public void delete(Integer id) {
		User obj = find(id);
		userRepository.delete(obj);
	}

	private void updateObj(User newObj, User obj) {
		newObj.setFullName(obj.getFullName());
		newObj.setPhone(obj.getPhone());
		newObj.setEmail(obj.getEmail());
		newObj.setPassword(obj.getPassword());
	}

	public User fromDto(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getFullName(), objDto.getCpf(), objDto.getPhone(), objDto.getEmail(), objDto.getPassword());
	}
	
	public User fromDto(UserUpdateDTO objDto) {
		return new User(objDto.getId(), objDto.getFullName(), null, objDto.getPhone(), objDto.getEmail(), objDto.getPassword());
	}
	
	public Page<User> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return userRepository.findAll(pageRequest);
	}
}
