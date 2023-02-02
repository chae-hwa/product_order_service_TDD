package com.example.product_order_service.product;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static org.springframework.util.Assert.*;

@Entity
@Table(name = "products")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public
class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
    private DiscountPolicy discountPolicy;

    public Product(final String name, final int price, final DiscountPolicy discountPolicy) {
        hasText(name, "상품명은 필수입니다.");
        isTrue(price > 0, "상품 가격은 0보다 커야 합니다.");
        notNull(discountPolicy, "할인 정책은 필수입니다.");
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

    public void update(final String name, final int price, final DiscountPolicy discountPolicy) {
        hasText(name, "상품명은 필수입니다.");
        isTrue(price > 0, "상품 가격은 0보다 커야 합니다.");
        notNull(discountPolicy, "할인 정책은 필수입니다.");
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }
}
