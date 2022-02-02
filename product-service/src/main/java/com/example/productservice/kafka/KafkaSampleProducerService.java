package com.example.productservice.kafka;

import com.example.productservice.dto.SalesDto;
import com.example.productservice.dto.SalesKafkaDto;
import com.example.productservice.entity.SalesEntity;
import com.example.productservice.repository.SalesJpaRepository;
import com.example.productservice.service.CategoryService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class KafkaSampleProducerService {
    @Autowired
    CategoryService categoryService;
    @Autowired
    SalesJpaRepository salesJpaRepository;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(){
        List<SalesEntity> salesEntities=salesJpaRepository.findAll();
        LinkedList<SalesDto> salesDtos= new LinkedList<>();
        for(int i=0; i<salesEntities.size();i++){
            SalesEntity salesEntity=salesEntities.get(i);
            salesDtos.add(
                    new SalesDto(
                            salesEntity.getSalesIdx(),
                            salesEntity.getProductName(),
                            salesEntity.getProductPrice(),
                            salesEntity.getQuantity(),
                            salesEntity.getTotalPrice(),
                            categoryService.getMatchedCategory(salesEntity)
                    )
            );
        }

        SalesKafkaDto salesKafkaDto= new SalesKafkaDto();
        salesKafkaDto.setData(salesDtos);

        Gson gson= new Gson();
        String message= gson.toJson(salesKafkaDto);
        System.out.println("send message : " + message);
        this.kafkaTemplate.send("test-topic2", message);
    }
}
