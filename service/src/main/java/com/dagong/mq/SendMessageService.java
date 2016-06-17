package com.dagong.mq;

import com.alibaba.fastjson.JSON;
import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

/**
 * Created by liuchang on 16/3/17.
 */
@Service
public class SendMessageService {

    @Value("${rocketmq.address}")
    private String mqAddress;
    private DefaultMQProducer defaultMQProducer;

    @PostConstruct
    public void init() throws MQClientException {
        defaultMQProducer = new DefaultMQProducer("Producer_"+System.currentTimeMillis());
        defaultMQProducer.setNamesrvAddr(mqAddress);
        defaultMQProducer.setVipChannelEnabled(false);
        defaultMQProducer.start();
    }

    @PreDestroy
    public void destroy() {
        if (defaultMQProducer != null) {
            defaultMQProducer.shutdown();
        }
    }



    public void sendMessage(String topic,String tag, Object message) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        String key = UUID.randomUUID().toString();
        Message msg = new Message(topic, tag, key, JSON.toJSONBytes(message));
        SendResult sendResult = defaultMQProducer.send(msg);
        System.out.println("key = " + key);
        System.out.println("sendResult = " + sendResult.getMsgId() + ":" + sendResult.getSendStatus());
    }



}
