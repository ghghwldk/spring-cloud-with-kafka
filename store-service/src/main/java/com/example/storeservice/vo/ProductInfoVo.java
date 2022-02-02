package com.example.storeservice.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ProductInfoVo {
    String productName;
    Integer productPrice;
}
