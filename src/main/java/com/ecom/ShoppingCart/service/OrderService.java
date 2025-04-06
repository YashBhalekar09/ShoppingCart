package com.ecom.ShoppingCart.service;

import java.util.List;

import com.ecom.ShoppingCart.model.OrderRequest;
import com.ecom.ShoppingCart.model.ProductOrder;


public interface OrderService {

	public void saveOrder(Integer userid,OrderRequest orderRequest);
	
	public List<ProductOrder> getOrdersByUser(Integer userId);

	public ProductOrder updateOrderStatus(Integer id, String status);
	
	public List<ProductOrder> getAllOrders();
}
