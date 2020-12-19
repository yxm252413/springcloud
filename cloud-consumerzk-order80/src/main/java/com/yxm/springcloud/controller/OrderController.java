package com.yxm.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Classname OrderController
 * @Description TODO
 * @Date 2020/12/19
 * @Created by yxm
 */
@RestController
@Slf4j
public class OrderController {
    private static final String url = "http://cloud-provider-payment";
    @Resource
    public RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String payment() {
        String string = restTemplate.getForObject(url + "/payment/zk", String.class);
        return string;
    }

}
