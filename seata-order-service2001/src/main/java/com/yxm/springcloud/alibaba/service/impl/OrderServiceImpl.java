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
 * @Description 创建订单>调用库存服务扣减库存>调用账户服务扣减余额>修改订单状态
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
//        新建订单
        log.info("------------》开始新建订单");
        orderDao.create(order);
        log.info("------------》开始新建订单END");
//减库存
        log.info("------------》订单微服务开始调用库存，做扣减count");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("------------》订单微服务开始调用库存，做扣减END");
//减余额
        log.info("------------》订单微服务开始调用支付，做扣减money");
        accountService.decrease(order.getProductId(), order.getMoney());
        log.info("------------》订单微服务开始调用支付，做扣减END");
//        修改订单状态
        //修改订单状态，从0到1，1表示已完成
        log.info("------------》修改订单开始");
        orderDao.update(order.getUserId(), 0);
        log.info("------------》修改订单开始");
        log.info("------------》下订单结束了，哈哈hhhhh");
    }
}
