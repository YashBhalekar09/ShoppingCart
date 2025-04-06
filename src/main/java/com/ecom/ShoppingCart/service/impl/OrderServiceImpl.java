package com.ecom.ShoppingCart.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.ShoppingCart.model.Cart;
import com.ecom.ShoppingCart.model.OrderAddress;
import com.ecom.ShoppingCart.model.OrderRequest;
import com.ecom.ShoppingCart.model.ProductOrder;
import com.ecom.ShoppingCart.repository.CartRepository;
import com.ecom.ShoppingCart.repository.ProductOrderRepository;
import com.ecom.ShoppingCart.service.OrderService;
import com.ecom.ShoppingCart.util.CommonUtil;
import com.ecom.ShoppingCart.util.OrderStatus;

@Service
public class OrderServiceImpl implements OrderService {

    private final ProductOrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final CommonUtil commonUtil;

    @Autowired
    public OrderServiceImpl(ProductOrderRepository orderRepository, CartRepository cartRepository, CommonUtil commonUtil) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
        this.commonUtil = commonUtil;
    }

    @Override
    public void saveOrder(Integer userId, OrderRequest orderRequest) {
        List<Cart> carts = cartRepository.findByUserId(userId);
        for (Cart cart : carts) {
            //System.out.println("Processing cart: " + cart);

            ProductOrder order = new ProductOrder();
            order.setOrderId(UUID.randomUUID().toString());
            order.setOrderDate(LocalDate.now());

            order.setProduct(cart.getProduct());
            order.setPrice(cart.getProduct().getDiscountPrice());
            order.setQuantity(cart.getQuantity());
            order.setUser(cart.getUser());

            order.setStatus(OrderStatus.IN_PROGRESS.getName());
            order.setPaymentType(orderRequest.getPaymentType());

            OrderAddress address = new OrderAddress();
            address.setFirstName(orderRequest.getFirstName());
            address.setLastName(orderRequest.getLastName());
            address.setEmail(orderRequest.getEmail());
            address.setMobileNo(orderRequest.getMobileNo());
            address.setAddress(orderRequest.getAddress());
            address.setCity(orderRequest.getCity());
            address.setState(orderRequest.getState());
            address.setPincode(orderRequest.getPincode());

            order.setOrderAddress(address);
            orderRepository.save(order);
        }
    }

	@Override
	public List<ProductOrder> getOrdersByUser(Integer userId) {
		List<ProductOrder> orders=orderRepository.findByUserId(userId);
		
		return orders;
	}

	@Override
	public ProductOrder updateOrderStatus(Integer id, String status) {
		Optional<ProductOrder> findById = orderRepository.findById(id);
		if (findById.isPresent()) {
			ProductOrder productOrder = findById.get();
			productOrder.setStatus(status);
			ProductOrder updateOrder = orderRepository.save(productOrder);
			return updateOrder;
		}
		return null;
	}

	@Override
	public List<ProductOrder> getAllOrders() {
		
		return orderRepository.findAll();
	}
	
	

}
