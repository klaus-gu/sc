package xyz.turboklaus.sc.stream.rocketmq.properties;

import org.springframework.cloud.stream.binder.BinderSpecificPropertiesProvider;

/**
 * @author Turbo Klaus
 * @author <a href="mailto:guyue375@outlook.com">klaus</a>
 * @program sc
 *
 * get properties for both consumer and producer
 *
 **/
public class RocketMQBindingProperties implements BinderSpecificPropertiesProvider {

    private RocketMQConsumerProperties consumer = new RocketMQConsumerProperties();

    private RocketMQProducerProperties producer = new RocketMQProducerProperties();

    public void setConsumer(RocketMQConsumerProperties consumer) {
        this.consumer = consumer;
    }

    public void setProducer(RocketMQProducerProperties producer) {
        this.producer = producer;
    }

    @Override
    public Object getConsumer() {
        return this.consumer;
    }

    @Override
    public Object getProducer() {
        return this.producer;
    }
}
