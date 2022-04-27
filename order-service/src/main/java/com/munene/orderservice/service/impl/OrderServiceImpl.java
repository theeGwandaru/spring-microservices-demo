package com.munene.orderservice.service.impl;

import com.munene.dto.OrderDto;
import com.munene.orderservice.domain.Order;
import com.munene.orderservice.domain.OrderStatus;
import com.munene.orderservice.repository.OrderRepository;
import com.munene.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderDto create(OrderDto orderDto) {
        Order order = new Order();
        order.setUserId(orderDto.getUserDto().getId());
        order.setAmount(orderDto.getAmount());
        order.setOrderStatus(OrderStatus.NEW);
        order = this.create(order);
        orderDto.setId(order.getId());
        return orderDto;
    }

    @Override
    public Order create(Order order) {
        order = this.orderRepository.save(order);
        return order;
    }
}
