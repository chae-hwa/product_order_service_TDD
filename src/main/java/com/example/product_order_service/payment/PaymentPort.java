package com.example.product_order_service.payment;

import com.example.product_order_service.order.Order;
import org.springframework.stereotype.Component;

@Component
interface PaymentPort {
    Order getOrder(Long orderId);

    void pay(int totalPrice, String cardNumber);

    void save(Payment payment);
}
