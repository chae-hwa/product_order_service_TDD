package com.example.product_order_service.product.application.service;

import com.example.product_order_service.product.domain.DiscountPolicy;

import static org.springframework.util.Assert.hasText;
import static org.springframework.util.Assert.notNull;

record GetProductResponse(long id, String name, int price, DiscountPolicy discountPolicy) {
    public GetProductResponse {
        notNull(id, "상품 ID는 필수입니다.");
        hasText(name, "상품명은 필수입니다.");
        notNull(discountPolicy, "할인 정책은 필수입니다.");
    }
}
