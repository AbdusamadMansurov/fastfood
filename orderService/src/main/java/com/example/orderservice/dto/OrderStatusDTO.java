package com.example.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderStatusDTO {
    private Long orderId;
    private String orderStatus;
    private boolean paymentStatus;
}
