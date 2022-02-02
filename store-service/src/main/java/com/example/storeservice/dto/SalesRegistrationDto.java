package com.example.storeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class SalesRegistrationDto {
    String productName;
    Integer productPrice;
    Integer quantity;
    Integer totalPrice;
}
