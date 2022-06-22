package com.example.orderservice.controller;

import com.example.orderservice.dto.ApiResponse;
import com.example.orderservice.dto.OrderDTO;
import com.example.orderservice.dto.OrderStatusDTO;
import com.example.orderservice.entity.Deliver;
import com.example.orderservice.entity.Order;
import com.example.orderservice.repository.DeliverRepository;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderRepository orderRepository;
    private final OrderService orderService;
    private final DeliverRepository deliverRepository;

    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok(orderRepository.findAll());
    }

    @GetMapping("/orders") // filialning o'zida qilingan buyurtmalar
    public ResponseEntity getAllOrders(){
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/delivers") // yetkazib berish uchun
    public ResponseEntity getAllDelivers(){
        List<Deliver> delivers = deliverRepository.findAll();
        return ResponseEntity.ok(delivers);
    }

    @PostMapping("/addOrder")
    public ResponseEntity addOrder(@RequestBody OrderDTO orderDTO){
       ApiResponse response = orderService.add(orderDTO);
       return ResponseEntity.ok(response);
    }

    @PostMapping("/editOrderStatus")
    public ResponseEntity editOrderStatus(@RequestBody OrderStatusDTO orderStatusDTO) {
        ApiResponse response = orderService.editOrderStatus(orderStatusDTO);
        return ResponseEntity.status(response.isSuccess() ? 200 : 400).body(response.getMessage());
    }












}
    