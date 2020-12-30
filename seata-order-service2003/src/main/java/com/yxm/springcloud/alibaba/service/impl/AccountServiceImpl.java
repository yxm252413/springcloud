package com.yxm.springcloud.alibaba.service.impl;

import com.yxm.springcloud.alibaba.dao.AccountDao;
import com.yxm.springcloud.alibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Classname AccountServiceImpl
 * @Description TODO
 * @Date 2020/12/30
 * @Created by yxm
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    //    扣减账号余额
    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------->account-service中扣减账户余额开始");
        accountDao.decrease(userId, money);
        log.info("------->account-service中扣减账户余额结束");
    }
}
