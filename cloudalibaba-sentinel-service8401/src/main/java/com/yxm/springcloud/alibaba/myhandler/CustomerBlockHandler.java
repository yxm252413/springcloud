package com.yxm.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yxm.springcloud.entities.CommonResult;

/**
 * @Classname CustomerBlockHandler
 * @Description 自定义限流逻辑类
 * @Date 2020/12/29
 * @Created by yxm
 */
public class CustomerBlockHandler {
    //方法必须是public static，返回值和controller中对应的方法返回值类型一致
    public static CommonResult handleException(BlockException exception) {
        return new CommonResult(2020, "自定义限流处理信息....CustomerBlockHandler", null);
    }

    public static CommonResult handleException2(BlockException exception) {
        return new CommonResult(2020, "自定义限流处理信息....CustomerBlockHandler2", null);
    }
}
