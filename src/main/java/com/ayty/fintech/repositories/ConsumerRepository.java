package com.ayty.fintech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayty.fintech.domain.Consumer;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Integer> {
}
