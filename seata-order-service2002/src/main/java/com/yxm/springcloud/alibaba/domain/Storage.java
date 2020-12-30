package com.yxm.springcloud.alibaba.domain;

import lombok.Data;

/**
 * @Classname Storage
 * @Description TODO
 * @Date 2020/12/30
 * @Created by yxm
 */
@Data
public class Storage {

    private Long id;

    // 产品id
    private Long productId;

    //总库存
    private Integer total;


    //已用库存
    private Integer used;


    //剩余库存
    private Integer residue;
}
