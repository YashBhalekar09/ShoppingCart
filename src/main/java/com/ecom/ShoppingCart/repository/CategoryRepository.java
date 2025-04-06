package com.ecom.ShoppingCart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.ShoppingCart.model.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer>{
	public Boolean existsByName(String name);
	
	public List<Category> findByIsActiveTrue();
}
