package com.example.orderservice.repository;

import com.example.orderservice.entity.Deliver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliverRepository extends JpaRepository<Deliver, Long> {
}
