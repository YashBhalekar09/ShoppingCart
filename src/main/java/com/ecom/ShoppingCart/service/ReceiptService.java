package com.ecom.ShoppingCart.service;


import com.ecom.ShoppingCart.model.OrderRequest;
import com.ecom.ShoppingCart.model.ReceiptData;

import org.springframework.stereotype.Service;

@Service
public class ReceiptService {

    public ReceiptData generateReceipt(OrderRequest request, Double productTotal) {
        ReceiptData receipt = new ReceiptData();

        receipt.setFirstName(request.getFirstName());
        receipt.setLastName(request.getLastName());
        receipt.setEmail(request.getEmail());
        receipt.setMobileNo(request.getMobileNo());
        receipt.setAddress(request.getAddress());
        receipt.setCity(request.getCity());
        receipt.setState(request.getState());
        receipt.setPincode(request.getPincode());
        receipt.setPaymentType(request.getPaymentType());

        Double deliveryFee = 250.0;
        Double tax = 100.0;
        Double totalPrice = productTotal + deliveryFee + tax;

        receipt.setProductTotal(productTotal);
        receipt.setDeliveryFee(deliveryFee);
        receipt.setTax(tax);
        receipt.setTotalPrice(totalPrice);

        return receipt;
    }
}
