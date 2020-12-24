package com.yxm.springcloud.service.impl;

import com.yxm.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Classname MessageProviderImpl
 * @Description 消息生产者实现类
 * @Date 2020/12/24
 * @Created by yxm
 */
@EnableBinding(Source.class)//定义消息推送通道,@EnableBinding是org.springframework.cloud.stream.annotation.EnableBinding;Source是org.springframework.cloud.stream.messaging.Source
public class MessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output;//消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        //MessageBuilder是org.springframework.integration.support.MessageBuilder
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("**************serial:" + serial);
        return null;
    }
}
