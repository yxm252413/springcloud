package com.yxm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname PaymentMain8004
 * @Description TODO
 * @Date 2020/12/18
 * @Created by yxm
 */
@SpringBootApplication
@EnableDiscoveryClient//consul/zookeeper使用此注解作为注册中心
public class PaymentZKMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentZKMain8004.class, args);
    }
}
