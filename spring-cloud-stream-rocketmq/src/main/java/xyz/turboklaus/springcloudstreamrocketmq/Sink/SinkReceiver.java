package xyz.turboklaus.springcloudstreamrocketmq.Sink;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @program: sc
 * <p>
 * [desc]
 * @author: Klaus_gu
 * @createTime: 2020-11-03 11:43
 * @vsersion: 1.0
 **/
@Slf4j
@EnableBinding(value = {Sink.class,SinkSender.class})
public class SinkReceiver {

    @StreamListener(Sink.INPUT)
    public void receive(Object payload){
        log.info("Receive :" +payload);
    }
}
