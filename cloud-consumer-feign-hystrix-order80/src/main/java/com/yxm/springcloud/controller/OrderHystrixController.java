package com.yxm.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
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
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")//定义全局的兜底方法，方法名为payment_Global_FallbackMethod
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
    /*@HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")//客户端峰值设置1500毫秒为峰值，如果超时，不在等待服务提供者响应，进入兜底方法。
    })//fallbackMethod = "paymentInfo_timeoutHandler", 设置兜底方法了就走指定兜底方法，利用这个特性，可以给核心重要的接口添加特定的兜底方法*/
    @HystrixCommand//@HystrixCommand表示服务降级，如果没有此注解就直接报错，如果有就到兜底函数，不写fallbackMethod属性，默认走全局的兜底方法
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

    //全局兜底方法
    public String payment_Global_FallbackMethod() {
        return "Global 对方方法超时或者宕机，请10秒后再次超时，/(ㄒoㄒ)/~~";
    }
}
