package com.example.productservice.entity;

import com.example.productservice.key.SalesKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter

@IdClass(SalesKey.class)
@Entity(name="sales")
public class SalesEntity {
    @Id
    Integer salesIdx;
    @Id
    String productName;
    Integer productPrice;
    Integer quantity;
    Integer totalPrice;
}