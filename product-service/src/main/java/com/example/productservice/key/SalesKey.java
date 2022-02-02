package com.example.productservice.key;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesKey implements Serializable {
    Integer salesIdx;
    String productName;
}
