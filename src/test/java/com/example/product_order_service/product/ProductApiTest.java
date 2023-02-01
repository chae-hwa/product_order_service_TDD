package com.example.product_order_service.product;

import com.example.product_order_service.ApiTest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductApiTest extends ApiTest {

    @DisplayName("상품 등록")
    @Test
    void t1() {
        final var request = ProductSteps.상품등록요청_생성();

        // API 요청
        final var response = ProductSteps.상품등록요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    @DisplayName("상품 조회")
    @Test
    void t2() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        Long productId = 1L;

        final var response = ProductSteps.상품조회요청(productId);

        assertThat((response.statusCode())).isEqualTo(HttpStatus.OK.value());
        assertThat(response.jsonPath().getString("name")).isEqualTo("상품명");
    }


}
