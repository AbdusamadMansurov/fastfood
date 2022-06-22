package com.example.couriermobile.repository;


import com.example.couriermobile.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
