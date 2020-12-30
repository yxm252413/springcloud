package com.yxm.springcloud.alibaba.controller;

import com.yxm.springcloud.alibaba.domain.CommonResult;
import com.yxm.springcloud.alibaba.domain.Storage;
import com.yxm.springcloud.alibaba.server.StorageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Classname StorageController
 * @Description TODO
 * @Date 2020/12/30
 * @Created by yxm
 */
@RestController
public class StorageController {
    @Resource
    private StorageService storageService;

    //扣减库存
    @RequestMapping(value = "/storage/decrease", method = RequestMethod.POST)
    public CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200, "扣减库存成功！");
    }

}
