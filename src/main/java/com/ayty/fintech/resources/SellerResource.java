package com.ayty.fintech.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ayty.fintech.domain.Seller;
import com.ayty.fintech.domain.User;
import com.ayty.fintech.dtos.SellerDTO;
import com.ayty.fintech.services.SellerService;
import com.ayty.fintech.services.UserService;

@Controller
@RequestMapping(value = "/api/users/sellers")
public class SellerResource {
	
	@Autowired
	private SellerService sellerService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody SellerDTO objDto) {
		Seller obj = sellerService.fromDto(objDto);
		obj = sellerService.insert(obj);
		User user = userService.find(obj.getUserId()).get();
		user.setSeller(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
				.path("/{id}").buildAndExpand(obj.getUserId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
