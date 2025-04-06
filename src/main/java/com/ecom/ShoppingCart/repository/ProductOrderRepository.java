package com.ecom.ShoppingCart.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.ShoppingCart.model.ProductOrder;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {
	
	public List<ProductOrder> findByUserId(Integer userId);
    
    ProductOrder findByOrderId(String orderId);
}
