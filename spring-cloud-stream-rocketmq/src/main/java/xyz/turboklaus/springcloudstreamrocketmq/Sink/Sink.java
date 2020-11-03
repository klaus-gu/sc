package xyz.turboklaus.springcloudstreamrocketmq.Sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @program: sc
 * <p>
 * [desc]
 * @author: Klaus_gu
 * @createTime: 2020-11-03 09:41
 * @vsersion: 1.0
 **/
public interface Sink {
    String INPUT ="input";

    @Input(Sink.INPUT)
    SubscribableChannel input();
}
