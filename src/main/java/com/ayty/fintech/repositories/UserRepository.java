package com.ayty.fintech.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayty.fintech.domain.Consumer;
import com.ayty.fintech.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public Optional<User> findById(Integer id);

	public Consumer save(Consumer obj);
}
