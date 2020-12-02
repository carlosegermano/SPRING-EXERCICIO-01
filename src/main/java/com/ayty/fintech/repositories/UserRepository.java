package com.ayty.fintech.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ayty.fintech.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Transactional(readOnly=true)
	List<User> findByFullNameContainingIgnoreCase(String name);
}
