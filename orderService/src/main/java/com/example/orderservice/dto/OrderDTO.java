package com.example.orderservice.dto;

import com.example.orderservice.entity.OrderProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO {

    private List<OrderProductDTO> orderProductDTO;
    private Long operatorId, filialId;
    private String payType;
    private Long humanId;
    private Integer stolNum;
}
