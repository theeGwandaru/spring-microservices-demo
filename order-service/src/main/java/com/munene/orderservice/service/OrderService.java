package com.munene.orderservice.service;

import com.munene.dto.OrderDto;
import com.munene.orderservice.domain.Order;

public interface OrderService {
    public OrderDto create(OrderDto orderDto);
    public Order create(Order order);
}
