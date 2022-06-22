package com.example.couriermobile.repository;

import com.example.couriermobile.entity.CourierActiveTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierActiveTableRepository extends JpaRepository<CourierActiveTable, Long>{
}
