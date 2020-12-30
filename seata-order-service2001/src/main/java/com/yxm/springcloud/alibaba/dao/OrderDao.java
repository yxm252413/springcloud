package com.yxm.springcloud.alibaba.dao;

import com.yxm.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Classname OrderDao
 * @Description TODO
 * @Date 2020/12/30
 * @Created by yxm
 */
@Mapper
public interface OrderDao {
    //    新建订单
    void create(Order order);

    //    修改订单状态，从0改为1
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
