package com.yxm.springcloud.controller;

import com.yxm.springcloud.entities.CommonResult;
import com.yxm.springcloud.entities.Payment;
import com.yxm.springcloud.services.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname PaymentFeignController
 * @Description TODO
 * @Date 2020/12/20
 * @Created by yxm
 */
@RestController
public class PaymentFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id) {
        CommonResult<Payment> commonResult = paymentFeignService.get(id);
        return commonResult;
    }

    //测试openfeign超时
    @GetMapping("/consumer/payment/feign/timeout")
    public String feignTimeout() {
//        openfeign底层是ribbon,客户端默认等待1s.
        return paymentFeignService.feignTimeout();
    }
}
