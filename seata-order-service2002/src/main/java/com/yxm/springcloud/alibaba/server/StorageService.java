package com.yxm.springcloud.alibaba.server;

import org.apache.ibatis.annotations.Param;

/**
 * @Classname StorageService
 * @Description TODO
 * @Date 2020/12/30
 * @Created by yxm
 */
public interface StorageService {
    //    扣减库存信息
    void decrease(Long productId, Integer count);
}
