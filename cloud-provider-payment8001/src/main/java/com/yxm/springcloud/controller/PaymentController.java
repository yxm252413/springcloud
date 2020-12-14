package com.yxm.springcloud.controller;

import com.yxm.springcloud.entities.CommonResult;
import com.yxm.springcloud.entities.Payment;
import com.yxm.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Classname PaymentController
 * @Description TODO
 * @Date 2020/12/14
 * @Created by yxm
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*******插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "操作成功", result);
        } else {
            return new CommonResult(444, "操作失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult create(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("*******插入结果----------------：" + result);
        if (result != null) {
            return new CommonResult(200, "查询成功", result);
        } else {
            return new CommonResult(444, "没有找到对应的记录，查询id:" + id, null);
        }
    }
}
