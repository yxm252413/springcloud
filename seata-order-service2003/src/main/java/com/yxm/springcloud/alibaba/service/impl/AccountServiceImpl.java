package com.yxm.springcloud.alibaba.service.impl;

import com.yxm.springcloud.alibaba.dao.AccountDao;
import com.yxm.springcloud.alibaba.service.AccountService;
import com.yxm.springcloud.alibaba.util.IdGeneratorSnowflake;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Classname AccountServiceImpl
 * @Description 扣减账户余额
 * @Date 2020/12/30
 * @Created by yxm
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    @Autowired
    private IdGeneratorSnowflake idGeneratorSnowflake;

    //    扣减账号余额
    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------->account-service中扣减账户余额开始");
        //模拟超时异常
//        try {
//            TimeUnit.SECONDS.sleep(20);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        accountDao.decrease(userId, money);
        log.info("------->account-service中扣减账户余额结束");
    }

    @Override
    public String getIdBySnowflake() {
        //创建多线程
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            executorService.submit(() -> {
                System.out.println(idGeneratorSnowflake.snowflakeId());
            });
        }
        executorService.shutdown();//关闭线程
        return "hello,snowflake";
    }
}
