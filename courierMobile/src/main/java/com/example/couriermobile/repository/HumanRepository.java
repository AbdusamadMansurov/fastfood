package com.example.couriermobile.repository;

import com.example.couriermobile.entity.Human;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumanRepository extends JpaRepository<Human, Long> {
}
