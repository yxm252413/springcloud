package com.yxm.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname ApplicationContextConfig
 * @Description TODO
 * @Date 2020/12/14
 * @Created by yxm
 */

@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced//使用@LoadBalanced注解赋予RestTemplate负载均衡的能力,默认的是轮询，譬如8001和8002服务交替使用
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}

