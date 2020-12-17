package com.ayty.fintech.user;

import java.util.List;

import org.springframework.data.domain.Page;

public interface UserService {

	User insert(User obj);
	User find(Integer id);
	List<User> findByFullNameContainingIgnoreCase(String name);
	List<User> findAll();
	User update(User obj);
	void delete(Integer id);
	User fromDto(UserDTO obj);
	User fromDto(UserUpdateDTO obj);
	Page<User> findPage(Integer page, Integer linesPerPage, String orderBy, String direction);
	
}
