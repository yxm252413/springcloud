package com.yxm.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Classname Payment
 * @Description Payment实体类
 * @Date 2020/12/13
 * @Created by yxm
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {//implements Serializable分布式会用到
    private Long id;
    private String serial;
}
