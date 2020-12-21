package com.yxm.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Classname PaymentFallbackService
 * @Description TODO
 * @Date 2020/12/21
 * @Created by yxm
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_ok(Integer id) {
        return "PaymentFallbackService.paymentInfo_ok,(⊙﹏⊙)";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "PaymentFallbackService.paymentInfo_timeout,(⊙﹏⊙)";
    }
}
