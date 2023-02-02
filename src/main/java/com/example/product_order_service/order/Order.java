package com.example.product_order_service.order;

import com.example.product_order_service.product.Product;

import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notNull;

class Order {
    private Long id;
    private final Product product;
    private final int quantity;

    public Order(final Product product, final int quantity) {
        notNull(product, "상품은 필수입니다.");
        isTrue(quantity > 0, "수량은 0보다 커야 합니다.");
        this.product = product;
        this.quantity = quantity;
    }

    public void assignId(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
