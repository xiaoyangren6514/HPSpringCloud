package com.happy.springcloud.controller;

import com.happy.springcloud.entities.CommonResult;
import com.happy.springcloud.entities.Payment;
import com.happy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("***插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入成功", result);
        } else {
            return new CommonResult(-1, "数据插入失败");
        }
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("***查询结果***：" + result);
        log.info("***当前处理端口***：" + serverPort);
        if (result != null) {
            return new CommonResult(200, "查询成功,result:" + result + ",serverPort:" + serverPort, result);
        } else {
            return new CommonResult(-1, "没有对应记录，查询ID：" + id);
        }
    }
}
