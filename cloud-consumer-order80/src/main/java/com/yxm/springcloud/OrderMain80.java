package com.yxm.springcloud;

import com.yxm.myrule.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Classname OrderMain80
 * @Description TODO
 * @Date 2020/12/14
 * @Created by yxm
 */
@EnableEurekaClient
@SpringBootApplication
//configuration = MyselfRule.class是自己自定义的轮询类；name = "CLOUD-PAYMENT-SERVICE"注册中心注册的服务CLOUD-PAYMENT-SERVICE要和注册中心中的一致，大小写一致
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyselfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }

}

