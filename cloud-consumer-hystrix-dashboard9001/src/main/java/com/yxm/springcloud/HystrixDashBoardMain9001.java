package com.yxm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Classname HystrixDashBoardMain9001
 * @Description TODO
 * @Date 2020/12/22
 * @Created by yxm
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashBoardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashBoardMain9001.class, args);
    }
}
