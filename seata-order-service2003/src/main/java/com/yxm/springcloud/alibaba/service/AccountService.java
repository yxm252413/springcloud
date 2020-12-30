package com.yxm.springcloud.alibaba.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Classname AccountService
 * @Description TODO
 * @Date 2020/12/30
 * @Created by yxm
 */
public interface AccountService {
    //    扣减账号余额
    void decrease(Long userId, BigDecimal money);

    //雪花算法
    String getIdBySnowflake();
}
