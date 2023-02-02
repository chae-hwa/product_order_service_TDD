package com.example.product_order_service.order;

import java.util.HashMap;
import java.util.Map;

class OrderRepository {
    private final Map<Long, Order> persitence = new HashMap<>();
    private Long sequence = 0L;

    public void save(final Order order) {
        order.assignId(++sequence);
        persitence.put(order.getId(), order);
    }
}