package xyz.turboklaus.springcloudstreamrocketmq.Sink;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @program: sc
 * <p>
 * [desc]
 * @author: Klaus_gu
 * @createTime: 2020-11-03 09:41
 * @vsersion: 1.0
 **/
public interface SinkSender {

    /**
     * 将{@link Sink} input 作为输出通道
     * @return
     */
    @Output(Sink.INPUT)
    MessageChannel output();

}
