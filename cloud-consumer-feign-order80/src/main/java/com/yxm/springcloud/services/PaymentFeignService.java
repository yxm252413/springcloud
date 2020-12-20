package com.yxm.springcloud.services;

import com.yxm.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Classname PaymentFeignService
 * @Description TODO
 * @Date 2020/12/20
 * @Created by yxm
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id);
}
