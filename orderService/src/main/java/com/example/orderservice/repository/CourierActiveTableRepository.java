package com.example.orderservice.repository;

import com.example.orderservice.entity.CourierActiveTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierActiveTableRepository extends JpaRepository<CourierActiveTable, Long>{
}
