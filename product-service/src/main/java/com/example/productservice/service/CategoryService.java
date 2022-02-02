package com.example.productservice.service;

import com.example.productservice.dto.SalesRegistrationDto;
import com.example.productservice.entity.SalesEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    public String getMatchedCategory(SalesEntity salesEntity){
        String productName= salesEntity.getProductName();
        if(productName.equals("product1")){
            return "t-shirt";
        }else if(productName.equals("product2")){
            return "jean";
        }else{
            return "pants";
        }

    }
}
