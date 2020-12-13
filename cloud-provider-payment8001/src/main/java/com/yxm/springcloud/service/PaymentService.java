package com.yxm.springcloud.service;

import com.yxm.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Classname Payment
 * @Description TODO
 * @Date 2020/12/14
 * @Created by yxm
 */
public interface PaymentService {
    //添加
    public int create(Payment payment);

    //查询
    public Payment getPaymentById(@Param("id") Long id);
}
