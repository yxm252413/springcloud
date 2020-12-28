package com.yxm.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Classname FlowLimitController
 * @Description 限流：
 * 1.快速失败源码com.alibaba.csp.sentinel.slots.block.flow.controller.DefaultController
 * 2.预热源码：com.alibaba.csp.sentinel.slots.block.flow.controller.WarmUpController
 * 3.排队等候源码：com.alibaba.csp.sentinel.slots.block.flow.controller.RateLimiterController
 * @Date 2020/12/28
 * @Created by yxm
 */
@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + "testB");
        return "------testB";
    }

    //测试sentinel降级--RT
    @GetMapping("/testD")
    public String testD() {
        //测试sentinel降级--RT
        /*try {
            log.info(Thread.currentThread().getName() + "\t" + "testD");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        ////测试sentinel降级--异常比例
        log.info("testD,异常比例");
        int age = 10 / 0;
        return "------testD";
    }

    //测试sentinel降级--异常数
    @GetMapping("/testE")
    public String testE() {
        //测试sentinel降级--异常数
        log.info("testE,测试异常数");
        int age = 10 / 0;
        return "------testE,测试异常数";
    }
}