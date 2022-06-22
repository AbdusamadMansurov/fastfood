package com.example.couriermobile.repository;


import com.example.couriermobile.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepoSitory extends JpaRepository<OrderProduct, Long> {
}
