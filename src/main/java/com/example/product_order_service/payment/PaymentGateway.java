package com.example.product_order_service.payment;

interface PaymentGateway {
    public void excute(int totalPrice, String cardNumber);
}
