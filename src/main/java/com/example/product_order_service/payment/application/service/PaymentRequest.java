package com.example.product_order_service.payment.application.service;

import static org.springframework.util.Assert.hasText;
import static org.springframework.util.Assert.notNull;

record PaymentRequest(Long orderId, String cardNumber) {
    PaymentRequest {
        notNull(orderId, "주문 ID는 필수입니다.");
        hasText(cardNumber, "카드 번호는 필수입니다.");
    }
}
