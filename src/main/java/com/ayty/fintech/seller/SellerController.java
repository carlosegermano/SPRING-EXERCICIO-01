package com.ayty.fintech.seller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ayty.fintech.user.User;
import com.ayty.fintech.user.UserServiceImpl;

@Controller
@RequestMapping(value = "/api/users/sellers")
public class SellerController {
	
	@Autowired
	private SellerServiceImpl sellerService;
	
	@Autowired
	private UserServiceImpl userService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody SellerDTO objDto) {
		Seller obj = sellerService.fromDto(objDto);
		obj = sellerService.insert(obj);
		User user = userService.find(obj.getUserId());
		user.setSeller(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
				.path("/{id}").buildAndExpand(obj.getUserId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
