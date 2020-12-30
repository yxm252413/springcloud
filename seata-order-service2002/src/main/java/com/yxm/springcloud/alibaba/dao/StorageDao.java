package com.yxm.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Classname StorageDao
 * @Description TODO
 * @Date 2020/12/30
 * @Created by yxm
 */
@Mapper
public interface StorageDao {
    //    扣减库存信息
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
