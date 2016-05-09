package com.dagong.mq;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.MessageExt;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liuchang on 16/4/16.
 */
public abstract class MessageProcessor implements MessageListenerConcurrently{

    @Resource
    private ReceiveMessageManager receiveMessageManager;

    private String topic;

    private String tag;


    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public ReceiveMessageManager getReceiveMessageManager() {
        return receiveMessageManager;
    }

    public void setReceiveMessageManager(ReceiveMessageManager receiveMessageManager) {
        this.receiveMessageManager = receiveMessageManager;
    }
    @PostConstruct
    public void init(){
        try {
            System.out.println("MessageProcessor.init");
            receiveMessageManager.addConsumber(this);
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    @Override
    public  ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext){

process(list);

        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    };
    protected abstract void process(List<MessageExt> list);

}
