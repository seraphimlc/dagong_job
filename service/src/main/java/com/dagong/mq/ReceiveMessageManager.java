package com.dagong.mq;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by liuchang on 16/4/15.
 */
@Service
public class ReceiveMessageManager {

    @Resource
    private MQConfiguration mqConfiguration;

    private List<MessageProcessor> messageProcessorList = new ArrayList<>();
    private List<DefaultMQPushConsumer> consumerList = new ArrayList<>();

    public void addConsumber(MessageProcessor messageProcessor) throws MQClientException {
        messageProcessorList.add(messageProcessor);
        consumerList.add(createMessageConsumer(messageProcessor));
    }

    private DefaultMQPushConsumer createMessageConsumer(MessageProcessor messageProcessor) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumber_" + UUID.randomUUID().toString());
        consumer.setNamesrvAddr(mqConfiguration.getNameSrvAddr());
        consumer.subscribe(messageProcessor.getTopic(), messageProcessor.getTag());
        consumer.setVipChannelEnabled(false);
        consumer.setPullInterval(1000);
        consumer.setConsumeMessageBatchMaxSize(10);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.registerMessageListener(messageProcessor);
        consumer.start();
        return consumer;
    }

  @PreDestroy
    public void destroy(){
        for(DefaultMQPushConsumer defaultMQPushConsumer:consumerList){
            defaultMQPushConsumer.shutdown();
        }
    }
}
