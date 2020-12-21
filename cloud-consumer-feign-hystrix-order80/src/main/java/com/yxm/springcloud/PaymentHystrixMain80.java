package com.yxm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Classname PaymentHystrixMain8001
 * @Description TODO
 * @Date 2020/12/21
 * @Created by yxm
 */
@SpringBootApplication
@EnableFeignClients
public class PaymentHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain80.class, args);
    }
}
