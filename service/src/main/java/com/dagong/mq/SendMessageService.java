package com.dagong.mq;

import com.alibaba.fastjson.JSON;
import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by liuchang on 16/3/17.
 */
@Service
public class SendMessageService {

    @Resource
    private MQConfiguration mqConfiguration;
    private DefaultMQProducer defaultMQProducer;

    @PostConstruct
    public void init() throws MQClientException {
        defaultMQProducer = new DefaultMQProducer("Producer_"+System.currentTimeMillis());
        defaultMQProducer.setNamesrvAddr(mqConfiguration.getNameSrvAddr());
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

    public static void main(String[] args) {
        Map map = new HashMap<String,Object>();
        map.put("aaaa","bbbb");
        System.out.println("new String(JSON.toJSONBytes(map)) = " + new String(JSON.toJSONBytes(map)));
    }

}
