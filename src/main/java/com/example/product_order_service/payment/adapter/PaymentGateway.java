package com.example.product_order_service.payment.adapter;

import org.springframework.stereotype.Component;

@Component
interface PaymentGateway {
    public void excute(int totalPrice, String cardNumber);
}
