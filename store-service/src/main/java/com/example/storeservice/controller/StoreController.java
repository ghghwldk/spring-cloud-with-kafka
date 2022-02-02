package com.example.storeservice.controller;

import com.example.storeservice.dto.SalesRegistrationDto;
import com.example.storeservice.vo.ProductInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.storeservice.feign.ProductServiceClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@RestController
public class StoreController {
    @Autowired
    ProductServiceClient productServiceClient;
    @PostMapping("/")
    public HashMap<String, String> registerSalesData(){
        // 0. setting of products
        List<ProductInfoVo> productInfoVos= new ArrayList<>(){{
            add(new ProductInfoVo("product1", 10000));
            add(new ProductInfoVo("product2", 20000));
            add(new ProductInfoVo("product3", 30000));
        }};

        // 1. make sales data
        Random random = new Random();
        List<SalesRegistrationDto> salesRegistrationDtos= new ArrayList<>();
        for(int productIdx=0; productIdx<3; productIdx++){
            String productName= productInfoVos.get(productIdx).getProductName();
            Integer productPrice=productInfoVos.get(productIdx).getProductPrice();
            Integer quantity = random.nextInt(3);
            Integer totalPrice= quantity * productPrice;
            if(! quantity.equals(0)){
                salesRegistrationDtos.add(new SalesRegistrationDto(productName, productPrice, quantity, totalPrice));
            }
        }
        // 2. send data to db-service by using openFeign
        productServiceClient.registerSalesData(salesRegistrationDtos);

        HashMap response= new HashMap();
        response.put("message", "success");
        return response;
    }
}
