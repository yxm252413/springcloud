package com.yxm.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname MyselfRule
 * @Description 自定义ribbon负载均衡规则，默认是轮询
 * @Date 2020/12/19
 * @Created by yxm
 */
@Configuration
public class MyselfRule {
    @Bean
    public IRule getRule() {
        return new RandomRule();//随机
    }
}
