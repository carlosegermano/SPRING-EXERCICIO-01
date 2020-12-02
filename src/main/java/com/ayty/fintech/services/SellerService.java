package com.ayty.fintech.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayty.fintech.domain.Seller;
import com.ayty.fintech.dtos.SellerDTO;
import com.ayty.fintech.repositories.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository sellerRepository;
	
	public Seller insert(Seller obj) {
		return sellerRepository.save(obj);
	}
	
	public Seller fromDto(SellerDTO objDto) {
		return new Seller(objDto.getId(), objDto.getUserId(), objDto.getCnpj(), objDto.getFantasyName(), objDto.getSocialName(), objDto.getUsername());
	}
}
