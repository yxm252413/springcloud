package com.yxm.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Classname FeignConfig
 * @Description TODO
 * @Date 2020/12/21
 * @Created by yxm
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;//日志最全，级别为full。
    }
}
