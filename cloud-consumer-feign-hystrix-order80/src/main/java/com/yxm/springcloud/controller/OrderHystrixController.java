package com.yxm.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yxm.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname OrderHystrixController
 * @Description TODO
 * @Date 2020/12/21
 * @Created by yxm
 */
@RestController
@Slf4j
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_ok(id);
        log.info("*******************" + result);
        return result;
    }

    //超时模拟服务降级
    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")//客户端峰值设置1500毫秒为峰值，如果超时，不在等待服务提供者响应，进入兜底方法。
    })
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Integer id) {
        int age = 10 / 0;//程序运行错误，直接进入兜底方法。
        String result = paymentHystrixService.paymentInfo_timeout(id);
        log.info("*******************" + result);
        return result;
    }

    public String paymentInfo_timeoutHandler(@PathVariable("id") Integer id) {
        return "我是消费者80，对付支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,(┬＿┬)";
    }
}
