package com.example.storageservice.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KafkaSampleConsumerService {
    @KafkaListener(topics="test-topic2", groupId="group-id-test-topic")
    public void consume(String message)throws IOException {
        System.out.println("receive message : " + message);
    }
}
