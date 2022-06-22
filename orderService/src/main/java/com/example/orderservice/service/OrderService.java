package com.example.orderservice.service;

import com.example.orderservice.dto.ApiResponse;
import com.example.orderservice.dto.OrderDTO;
import com.example.orderservice.dto.OrderProductDTO;
import com.example.orderservice.dto.OrderStatusDTO;
import com.example.orderservice.entity.*;
import com.example.orderservice.entity.enums.OrderStatus;
import com.example.orderservice.entity.enums.PayType;
import com.example.orderservice.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final DeliverRepository deliverRepository;
    private final HumanRepo humanRepo;
    private final ProductRepo productRepo;
    private final OrderProductRepo orderProductRepo;
    private final FilialRepo filialRepo;

    public ApiResponse add(OrderDTO orderDTO) {
        List<OrderProductDTO> orderProductDTO = orderDTO.getOrderProductDTO();
//        String orderStatus = orderDTO.getOrderStatus();
        Long humanId = orderDTO.getHumanId();
        Long operatorId = orderDTO.getOperatorId();
        String payType1 = orderDTO.getPayType();
        Integer stolNum = orderDTO.getStolNum();
        Long filialId = orderDTO.getFilialId();

        Double price = null;
        List<OrderProduct> orderProducts = new ArrayList<>();
        for (OrderProductDTO productDTO : orderProductDTO) {
            OrderProduct orderProduct = new OrderProduct();
            Long productId = productDTO.getProductId();
            Integer count = productDTO.getCount();
            Product product = productRepo.getById(productId);
            orderProduct.setProduct(product);
            orderProduct.setCount(count);
            OrderProduct savedOrderProduct = orderProductRepo.save(orderProduct);
            orderProducts.add(savedOrderProduct);
            price += count * product.getPrice();
        }
        Human client = humanRepo.getById(humanId);
        Human operator = humanRepo.getById(operatorId);
        PayType payType = PayType.valueOf(payType1);
        Order order = new Order(orderProducts, operator, payType, price, filialRepo.getById(filialId),
                OrderStatus.NEW, client, stolNum);
        orderRepository.save(order);
        return ApiResponse.builder().message("Order added").success(true).build();
    }

    public List<Order> getAllOrders() {
        List<Order> allOrders = orderRepository.findAll();
        List<Order> alldeliverOrders = new ArrayList<>();
        List<Deliver> allDelivers = deliverRepository.findAll();
        for (Deliver allDeliver : allDelivers) {
            alldeliverOrders.add(allDeliver.getOrder());
        }
        allOrders.removeAll(alldeliverOrders);
        return allOrders;
    }

    public ApiResponse editOrderStatus(OrderStatusDTO orderStatusDTO) {
        Long orderId = orderStatusDTO.getOrderId();
        String dtoOrderStatus = orderStatusDTO.getOrderStatus();
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isEmpty())
            return ApiResponse.builder().success(false).message("Order is not found!!!").build();
        Order order = orderOptional.get();
        order.setOrderStatus(OrderStatus.valueOf(dtoOrderStatus));
        order.setPaid(orderStatusDTO.isPaymentStatus());
        return ApiResponse.builder().success(true).message("Order status is edited").build();
    }
}






