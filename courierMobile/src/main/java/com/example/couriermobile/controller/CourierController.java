package com.example.couriermobile.controller;

import com.example.couriermobile.dto.ApiResponse;
import com.example.couriermobile.entity.Deliver;
import com.example.couriermobile.entity.Order;
import com.example.couriermobile.feign.OrderFeign;
import com.example.couriermobile.service.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courier")
@RequiredArgsConstructor
public class CourierController {

    final OrderFeign orderFeign;
    final CourierService courierService;

    //TODO order entityga yetkazib beriladingan joy adresini qo'shish
    //TODO courier activeligini o'zi boshqara olishi kerak
    //TODO courierga buyurmatalarining holati ko'rinishi lozim
    //TODO courierning buyurmalar tarixi bo'lishi kerak
    //TODO courier barcha buyurtmalarni ko'rib istaganini tanlab yetkazib berishi mumkin

    @GetMapping()
    public ResponseEntity getAllDelivers(){
        List<Deliver> allDelivers= courierService.getAllDelivers();
//        List<Order> allOrders = orderFeign.getAllOrders();
        return ResponseEntity.ok(allDelivers);
    }

    @GetMapping("/getOneOrder/{id}")
    public ResponseEntity getOneOrder(@PathVariable Long id){
        Order order = orderFeign.getOneOrder(id);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/attachToCourier/{courierId}/{deliverId}")
    public ResponseEntity attachToCourier(@PathVariable Long courierId, @PathVariable Long deliverId){
        ApiResponse response = courierService.attachToCourier(courierId, deliverId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/editStatusCourier/{id}")
    public ResponseEntity editStatusCourier(@PathVariable Long id){
        ApiResponse response = courierService.editStatusCourier(id);
        return ResponseEntity.ok(response);
    }


}
