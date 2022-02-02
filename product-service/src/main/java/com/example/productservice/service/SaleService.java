package com.example.productservice.service;

import com.example.productservice.dto.SalesRegistrationDto;
import com.example.productservice.entity.SalesEntity;
import com.example.productservice.repository.SalesJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SaleService {
    int maximumSalesIdx=0;
    @Autowired
    SalesJpaRepository salesJpaRepository;

    @Transactional
    public void saveSales(List<SalesRegistrationDto> salesRegistrationDtos){
        for(int i=0; i<salesRegistrationDtos.size();i++){
            System.out.println("linelinelinelinelinelinelinelinelinelinelinelinelinelinelinelinelinelinelinelinelinelinelineline");
            SalesRegistrationDto s= salesRegistrationDtos.get(i);
            salesJpaRepository.save(
                    new SalesEntity(
                            this.maximumSalesIdx,
                            s.getProductName(),
                            s.getProductPrice(),
                            s.getQuantity(),
                            s.getTotalPrice()
                    )
            );
        }
        this.maximumSalesIdx++;
    }


}
