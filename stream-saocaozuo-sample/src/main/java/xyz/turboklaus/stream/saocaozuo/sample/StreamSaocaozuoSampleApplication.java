package xyz.turboklaus.stream.saocaozuo.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @author Turbo Klaus
 * @author <a href="mailto:guyue375@outlook.com">klaus</a>
 * @program sc
 * 一些额外的操作
 **/
@EnableBinding(value = {Sink.class,Source.class})
@SpringBootApplication
public class StreamSaocaozuoSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamSaocaozuoSampleApplication.class, args);
    }

    private static final String SAO_BU_SAO = "sao";

    /**
     * 定一个本地通道
     * @return
     */
    @Bean(StreamSaocaozuoSampleApplication.SAO_BU_SAO)
    public MessageChannel channel(){
        return new DirectChannel();
    }

    /**
     * 监听最后的消息
     * @param msg
     */
    @StreamListener(StreamSaocaozuoSampleApplication.SAO_BU_SAO)
    public void get(String msg){
        System.out.println("===>>> "+msg);
    }

    /**
     * 从input读到消息，然后转发到SAO_BU_SAO
     * @param message
     * @return
     */
    @ServiceActivator(inputChannel = Sink.INPUT,outputChannel = StreamSaocaozuoSampleApplication.SAO_BU_SAO)
    public String receive(Message message){
        System.out.println("######## "+message.getPayload());
        return "收到InboundChannelAdapter消息 ==>> 转发来自ServiceActivator";
    }

    /**
     * 让被注解方法自己发消息（类似于定时消息）
     * 1000ms发送一次消息
     * 一次发五条
     * @return
     */
    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT,
            poller = @Poller(fixedDelay = "1000", maxMessagesPerPoll = "5"))
    public Message<String> producer() {
        return MessageBuilder.withPayload("saosaosao").build();
    }

}
