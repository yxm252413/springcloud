package com.yxm.springcloud.service.impl;

import com.yxm.springcloud.dao.PaymentDao;
import com.yxm.springcloud.entities.Payment;
import com.yxm.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname PaymentServiceImpl
 * @Description TODO
 * @Date 2020/12/14
 * @Created by yxm
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    //@Autowired和 @Resource都能注入依赖类， @Resource是Javax提供的，@Autowired是spring提供的。
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
