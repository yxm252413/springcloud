package com.yxm.springcloud.dao;

import com.yxm.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Classname PaymentDao
 * @Description dao类
 * @Date 2020/12/14
 * @Created by yxm
 */
@Mapper
public interface PaymentDao {
    //添加
    public int create(Payment payment);

    //查询
    public Payment getPaymentById(@Param("id") Long id);
}
