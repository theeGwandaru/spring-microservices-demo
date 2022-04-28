package com.munene.orderservice.service.impl;

import com.munene.dto.OrderDto;
import com.munene.dto.PaymentDto;
import com.munene.orderservice.domain.Order;
import com.munene.orderservice.domain.OrderStatus;
import com.munene.orderservice.repository.OrderRepository;
import com.munene.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate paymentRestTemplate;

    private String PAYMENT_ENDPOINT_URL = "http://PAYMENT-SERVICE/payments";

    @Override
    public OrderDto create(OrderDto orderDto) {
        Order order = new Order();
        order.setUserId(orderDto.getUserDto().getId());
        order.setAmount(orderDto.getAmount());
        order.setOrderStatus(OrderStatus.NEW);

        order = this.create(order);
        orderDto.setId(order.getId());
        orderDto.setStatus(order.getOrderStatus().toString());

        return orderDto;
    }

    @Override
    public Order create(Order order) {

        order = this.orderRepository.save(order);
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setOrderId(order.getId());
        paymentDto.setAmount(order.getAmount());
        paymentDto = paymentRestTemplate.postForObject(PAYMENT_ENDPOINT_URL, paymentDto, PaymentDto.class);

        order.setOrderStatus(paymentDto.getStatus().equals("success") ? OrderStatus.COMPLETED : OrderStatus.DECLINED);

        this.orderRepository.save(order);
        return order;
    }
}
