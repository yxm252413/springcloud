package com.yxm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Classname PaymentHystrixMain8001
 * @Description TODO
 * @Date 2020/12/21
 * @Created by yxm
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker//开启hystrix降级服务注解
public class PaymentHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class, args);
    }
}
