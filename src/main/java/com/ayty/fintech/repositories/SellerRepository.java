package com.ayty.fintech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayty.fintech.domain.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {
}
