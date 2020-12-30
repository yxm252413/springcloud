package com.yxm.springcloud.alibaba.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Classname IdGeneratorSnowflake
 * @Description 在hutool包的基础上封装
 * @Date 2020/12/30
 * @Created by yxm
 */
@Component
@Slf4j
public class IdGeneratorSnowflake {
    private long workId = 0;//机器id
    private long datacenterId = 1;//数据中心
    private Snowflake snowflake = IdUtil.createSnowflake(workId, datacenterId);

    @PostConstruct//构造完成后开始执行，加载初始化
    public void init() {
        try {
            workId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
            log.info("当前机器码workId：" + workId);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("当前机器码获取失败" + e);
            workId = NetUtil.getLocalhostStr().hashCode();
        }
    }

    public synchronized long snowflakeId() {
        return snowflake.nextId();
    }

    public synchronized long snowflakeId(long workerId, long datacenterId) {
        Snowflake snowflake = IdUtil.createSnowflake(workId, datacenterId);
        return snowflake.nextId();
    }

    //测试id工具类生成id
    public static void main(String[] args) {
        System.out.println(new IdGeneratorSnowflake().snowflakeId());
    }
}
