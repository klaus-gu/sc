package xyz.turboklaus.stream.normal.sample;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author Turbo Klaus
 * @author <a href="mailto:guyue375@outlook.com">klaus</a>
 * @program sc
 **/
@Component
public class NormalService {

    /**
     * 注意{@link StreamListener}的condition，你可以用它对消息头的消息进行筛选
     * 注意格式的匹配，不做一一陈列
     * @param msg
     */
    @StreamListener(value = Sink.INPUT, condition = "headers['age']>='3'")
    public void receiveByHeader(Message msg) {
        System.out.println("我只要 age >= 3 的消息" + msg);
    }

    @StreamListener(value = Sink.INPUT, condition = "headers['age']=='33'")
    public void receivePerson(@Payload User user) {
        System.out.println("我要 age == 33 的 User：" + user);
    }

    @StreamListener(value = Sink.INPUT)
    public void receiveAllMsg(String msg) {
        System.out.println("我要所有 age 的消息" + msg);
    }

}
