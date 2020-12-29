package com.yxm.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yxm.springcloud.entities.CommonResult;
import com.yxm.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname RateLimitController
 * @Description TODO
 * @Date 2020/12/29
 * @Created by yxm
 */
@RestController
public class RateLimitController {
    //按照资源名称限流，即@SentinelResource(value = "byResource")中的value值
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
    }

    public CommonResult handleException(BlockException exception) {
        return new CommonResult(444, exception.getClass().getCanonicalName() + "\t 服务不可用", null);
    }

    //    按照url限流，即按照 @GetMapping("/rateLimit/byUrl")中的value值
    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200, "按url限流测试OK", new Payment(2020L, "serial002"));
    }
}
