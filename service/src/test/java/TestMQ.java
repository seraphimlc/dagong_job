import com.alibaba.rocketmq.client.consumer.DefaultMQPullConsumer;
import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.PullResult;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.alibaba.rocketmq.common.message.MessageQueue;
import com.alibaba.rocketmq.remoting.exception.RemotingException;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

/**
 * Created by liuchang on 16/4/11.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/base/all.xml")
public class TestMQ {
    //    @Test
    public static void ttt(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQPullConsumer consumer = new DefaultMQPullConsumer("pullConsumer");
        consumer.setNamesrvAddr("172.16.54.144:9876");
        consumer.start();
        Set<MessageQueue> messageQueues = consumer.fetchSubscribeMessageQueues("Job");
        for (MessageQueue messageQueue:
             messageQueues) {
            PullResult pullResult =

                    consumer.pullBlockIfNotFound(messageQueue, null, 0, 32);

            List<MessageExt> list = pullResult.getMsgFoundList();
            for (MessageExt messageExt:list){
                System.out.println("messageExt = " + messageExt);
            }

        }
    }

    public static void main(String args[]) {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("pushConsumer");
        consumer.setNamesrvAddr("172.16.54.144:9876");

        try {
            consumer.subscribe("Job", null);
            consumer.setVipChannelEnabled(false);
            consumer.setPullInterval(1000);
            consumer.setConsumeMessageBatchMaxSize(10);
            consumer.setInstanceName("PushConsumer");

            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            consumer.registerMessageListener(new MessageListenerConcurrently() {
                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                    list.forEach(messageExt -> {

                            System.out.println("messageExt = " + messageExt.getTags());

                    });
//                    System.out.println("list = " + list);
//                    for (MessageExt messageExt : list) {
//                        System.out.println("messageExt = " + messageExt);
//                    }
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });
            consumer.start();
            Thread.sleep(1000 * 600);
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
