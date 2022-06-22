package com.example.couriermobile.repository;

import com.example.couriermobile.entity.Deliver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeliverRepository extends JpaRepository<Deliver, Long> {
//    @Query(value = "select * from deliver where courier_id IS NULL",nativeQuery = true)
    List<Deliver> getDeliversByCourierIsNull();
}
