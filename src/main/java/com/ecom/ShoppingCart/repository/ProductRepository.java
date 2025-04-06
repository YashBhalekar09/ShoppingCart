package com.ecom.ShoppingCart.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.ShoppingCart.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findByIsActiveTrue();

	List<Product> findByCategory(String category);

	Page<Product> findByIsActiveTrue(Pageable pageable);

	Page<Product> findByCategory(Pageable pageable, String category);

	
}
