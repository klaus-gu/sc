package xyz.turboklaus.stream.sample.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

/**
 * @program: sc
 * <p>
 * [desc]
 * @author: Klaus_gu
 * @createTime: 2020-11-03 21:06
 * @vsersion: 1.0
 **/
public interface MySink {

    String HELLO = "receive";

    @Input(MySink.HELLO)
    MessageChannel receiveMsg();
}
