package com.example.product_order_service.payment;

import com.example.product_order_service.product.DiscountPolicy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DiscountPolicyTest {

    @Test
    void noneDiscountPolicy() {
        final int price = 1000;

        final int discountPrice = DiscountPolicy.NONE.applyDiscount(price);

        assertThat(discountPrice).isEqualTo(price);
    }

    @Test
    void fix_discountPolicy(){
        final int price = 2000;

        final int discountedPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price);

        assertThat(discountedPrice).isEqualTo(1000);
    }

    @Test
    void over_discounted_price() {
        final int price = 500;

        final int discountedPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price);

        assertThat(discountedPrice).isEqualTo(0);
    }
}
