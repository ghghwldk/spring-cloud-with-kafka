package com.example.productservice.controller;

import com.example.productservice.dto.SalesRegistrationDto;
import com.example.productservice.entity.SalesEntity;
import com.example.productservice.kafka.KafkaSampleProducerService;
import com.example.productservice.repository.SalesJpaRepository;
import com.example.productservice.service.SaleService;
import com.example.productservice.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class SalesController {
    @Autowired
    SalesJpaRepository salesJpaRepository;
    @Autowired
    KafkaSampleProducerService kafkaSampleProducerService;
    @Autowired
    SaleService saleService;
    @PostMapping("/register")
    HashMap<String, String> registerSalesData(@RequestBody List<SalesRegistrationDto> salesRegistrationDtos){
        saleService.saveSales(salesRegistrationDtos);

        return new HashMap<>(){{
            put("message", "success");
        }};
    }



    @GetMapping("/retrieve")
    HashMap<String, String> retrieve(){

        kafkaSampleProducerService.sendMessage();

        return new HashMap<>(){{
            put("message", "success");
        }};
    }

}
