package com.munene.paymentservice.service;

import com.munene.dto.PaymentDto;
import com.munene.paymentservice.domain.Payment;
import com.munene.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService  {

    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentDto create(PaymentDto paymentDto){
        Payment payment = new Payment();
        payment.setOrderId(paymentDto.getOrderId());
        payment.setAmount(paymentDto.getAmount());
        payment.setTransactionId(UUID.randomUUID().toString());
        payment.setStatus(processPayment(payment));

        payment = this.paymentRepository.save(payment);

        paymentDto.setId(payment.getId());
        paymentDto.setStatus(payment.getStatus());
        paymentDto.setTransactionId(payment.getTransactionId());

        return paymentDto;
    }

    public String processPayment(Payment payment){
        return new Random().nextBoolean()?"success":"false";
    }
}
