package com.happy.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    public static final String URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/test")
    public String test() {
        log.info("****order test called****");
        String content = restTemplate.getForObject(URL + "/payment/test", String.class);
        return content;
//        return restTemplate.getForObject(URL + "/payment/test", String.class);
    }
}
