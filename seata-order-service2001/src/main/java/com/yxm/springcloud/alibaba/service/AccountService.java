package com.yxm.springcloud.alibaba.service;

import com.yxm.springcloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Classname AccountService
 * @Description TODO
 * @Date 2020/12/30
 * @Created by yxm
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {
    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("money") BigDecimal money);
}
