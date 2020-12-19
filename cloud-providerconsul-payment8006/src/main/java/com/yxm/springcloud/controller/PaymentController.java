package com.yxm.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Classname PaymentController
 * @Description TODO
 * @Date 2020/12/19
 * @Created by yxm
 */
@Slf4j
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/consul")
    public String paymentzk() {

        return "springcloud with zookeeper:   " + serverPort + UUID.randomUUID().toString();
    }
}
