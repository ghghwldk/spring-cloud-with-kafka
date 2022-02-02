package com.example.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class SalesDto {
    Integer salesIdx;
    String productName;
    Integer productPrice;
    Integer quantity=0;
    Integer totalPrice=0;

    String category;
}
