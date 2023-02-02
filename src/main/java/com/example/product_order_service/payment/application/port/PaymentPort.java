package com.example.product_order_service.payment.application.port;

import com.example.product_order_service.order.domain.Order;
import com.example.product_order_service.payment.domain.Payment;
import org.springframework.stereotype.Component;

@Component
public
interface PaymentPort {
    Order getOrder(Long orderId);

    void pay(int totalPrice, String cardNumber);

    void save(Payment payment);
}
