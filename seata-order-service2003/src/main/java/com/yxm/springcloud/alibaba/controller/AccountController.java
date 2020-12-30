package com.yxm.springcloud.alibaba.controller;

import com.yxm.springcloud.alibaba.domain.CommonResult;
import com.yxm.springcloud.alibaba.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Classname AccountController
 * @Description TODO
 * @Date 2020/12/30
 * @Created by yxm
 */
@RestController
public class AccountController {
    @Resource
    private AccountService accountService;
    @RequestMapping(value = "/account/decrease",method = RequestMethod.POST)
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        accountService.decrease(userId, money);
        return new CommonResult(200, "扣减账户余额成功！");
    }

}
