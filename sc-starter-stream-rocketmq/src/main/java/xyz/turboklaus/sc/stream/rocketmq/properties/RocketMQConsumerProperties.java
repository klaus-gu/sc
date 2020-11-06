package xyz.turboklaus.sc.stream.rocketmq.properties;

import lombok.Data;
import org.apache.rocketmq.client.consumer.MQPushConsumer;
import org.apache.rocketmq.client.consumer.MessageSelector;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.Set;

/**
 * @author Turbo Klaus
 * @author <a href="mailto:guyue375@outlook.com">klaus</a>
 * @program sc
 * 消费者参数参考rocketmq的参数配置
 **/
@Data
public class RocketMQConsumerProperties {

    private String tags;

    private String sql;

    private Boolean broadcasting = false;

    private Boolean orderly = false;

    private int delayLevelWhenNextConsume = 0;

    private long suspendCurrentQueueTimeMillis = 1000;

    private Boolean enabled = true;

    private Set<String> trustedPackages;

    private long pullTimeout = 10 * 1000;

    private boolean fromStore;

}
