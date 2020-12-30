package com.yxm.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Classname AccountDao
 * @Description TODO
 * @Date 2020/12/30
 * @Created by yxm
 */
@Mapper
public interface AccountDao {
    //    扣减库存余额
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
