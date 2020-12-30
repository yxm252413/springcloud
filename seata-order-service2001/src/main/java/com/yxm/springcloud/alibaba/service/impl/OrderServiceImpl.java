package com.yxm.springcloud.alibaba.service.impl;

import com.yxm.springcloud.alibaba.dao.OrderDao;
import com.yxm.springcloud.alibaba.domain.Order;
import com.yxm.springcloud.alibaba.service.AccountService;
import com.yxm.springcloud.alibaba.service.OrderService;
import com.yxm.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname OrderServiceImpl
 * @Description TODO
 * @Date 2020/12/30
 * @Created by yxm
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;


    @Override
    public void create(Order order) {
        log.info("------------》开始新建订单");
        orderDao.create(order);
        log.info("------------》订单微服务开始调用库存，做扣减");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("------------》订单微服务开始调用库存，做扣减END");
        log.info("------------》订单微服务开始调用支付微服务，做扣减END");


    }
}
