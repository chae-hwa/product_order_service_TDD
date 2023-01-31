package com.example.product_order_service.product;

import static org.springframework.util.Assert.*;

class Product {
    private Long id;
    private final String name;
    private final int price;
    private final DiscountPolicy discountPolicy;

    public Product(final String name, final int price, final DiscountPolicy discountPolicy) {
        hasText(name, "상품명은 필수입니다.");
        isTrue(price > 0, "상품 가격은 0보다 커야 합니다.");
        notNull(discountPolicy, "할인 정책은 필수입니다.");
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

    public void assignId(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
