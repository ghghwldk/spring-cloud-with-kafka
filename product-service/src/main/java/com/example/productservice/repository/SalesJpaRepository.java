package com.example.productservice.repository;

import com.example.productservice.entity.SalesEntity;
import com.example.productservice.key.SalesKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalesJpaRepository extends JpaRepository<SalesEntity, SalesKey>{
    List<SalesEntity> findAll();
}