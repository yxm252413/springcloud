package com.yxm.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname MyBatisConfig
 * @Description TODO
 * @Date 2020/12/30
 * @Created by yxm
 */
@Configuration
@MapperScan("com.yxm.springcloud.alibaba.dao")
public class MyBatisConfig {
}