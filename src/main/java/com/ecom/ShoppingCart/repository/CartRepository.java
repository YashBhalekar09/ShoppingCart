package com.ecom.ShoppingCart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.ShoppingCart.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

	public Cart findByProductIdAndUserId(Integer productId, Integer userId);

	public Integer countByUserId(Integer userId);

	List<Cart> findByUserId(Integer userId);

	
	
}
