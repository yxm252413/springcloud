package com.yxm.springcloud.alibaba.service;

import com.yxm.springcloud.entities.CommonResult;
import com.yxm.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @Classname PaymentFallbackService
 * @Description TODO
 * @Date 2020/12/29
 * @Created by yxm
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444, "服务降级返回,---PaymentFallbackService", new Payment(id, "errorSerial"));
    }
}
