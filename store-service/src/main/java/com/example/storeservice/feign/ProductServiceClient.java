package com.example.storeservice.feign;

import com.example.storeservice.dto.SalesRegistrationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;


@FeignClient(name = "product-service")
public interface ProductServiceClient {
    @PostMapping("/register")
    HashMap<String, String> registerSalesData(@RequestBody List<SalesRegistrationDto> salesRegistrationDtos);
}



