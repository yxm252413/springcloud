package com.yxm.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname FlowLimitController
 * @Description
 * 限流：
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


}