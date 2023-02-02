package com.example.product_order_service.order;

import com.example.product_order_service.product.DiscountPolicy;
import com.example.product_order_service.product.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    private OrderService orderService;
    private OrderPort orderPort;
    private OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        orderRepository = new OrderRepository();
        orderPort = new OrderPort(){

            @Override
            public Product getProductById(Long productId) {
                return new Product("상품명", 1000, DiscountPolicy.NONE);
            }

            @Override
            public void save(Order order) {
                orderRepository.save(order);
            }
        };

        orderService = new OrderService(orderPort);
    }

    @DisplayName("상품 주문")
    @Test
    void t1() {
        final CreateOrderRequest request = 상품주문요청_생성();

        orderService.createOrder(request);
    }

    private CreateOrderRequest 상품주문요청_생성() {
        final Long productId = 1L;
        final int quantity = 2;
        return new CreateOrderRequest(productId, quantity);
    }

}
