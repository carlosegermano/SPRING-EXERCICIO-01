package com.ayty.fintech.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayty.fintech.exceptions.InvalidRequestException;
import com.ayty.fintech.user.User;
import com.ayty.fintech.user.UserServiceImpl;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerRepository sellerRepository;
	
	@Autowired
	private UserServiceImpl userService;

	public Seller insert(Seller obj) {

		User user = userService.find(obj.getUserId());

		if (user.getSeller() == null) {
			obj = sellerRepository.save(obj);
			user.setSeller(obj);
			userService.update(user);
			return obj;
		}

		throw new InvalidRequestException("Invalid Request!");
	}

	public Seller fromDto(SellerDTO objDto) {
		return new Seller(objDto.getId(), objDto.getUserId(), objDto.getCnpj(), objDto.getFantasyName(),
				objDto.getSocialName(), objDto.getUsername());
	}
}
