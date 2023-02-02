package com.example.product_order_service.order;

import com.example.product_order_service.product.Product;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notNull;

@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Product product;
    private int quantity;

    public Order(final Product product, final int quantity) {
        notNull(product, "상품은 필수입니다.");
        isTrue(quantity > 0, "수량은 0보다 커야 합니다.");
        this.product = product;
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return product.getDiscountedPrice() * quantity;
    }
}
