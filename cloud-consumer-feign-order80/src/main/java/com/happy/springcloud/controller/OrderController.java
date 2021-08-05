package com.happy.springcloud.controller;

import com.happy.springcloud.entities.CommonResult;
import com.happy.springcloud.entities.Payment;
import com.happy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        log.info("****feign****");
        return paymentService.getPaymentById(id);
    }

    @GetMapping("/payment/timeout")
    public String feignTimeOut() {
        return paymentService.mockTimeOut();
    }
}
