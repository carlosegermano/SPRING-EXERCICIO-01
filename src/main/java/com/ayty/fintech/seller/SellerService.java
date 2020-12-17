package com.ayty.fintech.seller;

public interface SellerService {

	Seller insert(Seller obj);
	Seller fromDto(SellerDTO obj);
}
