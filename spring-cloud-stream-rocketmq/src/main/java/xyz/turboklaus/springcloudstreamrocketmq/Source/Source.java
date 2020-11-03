package xyz.turboklaus.springcloudstreamrocketmq.Source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @program: sc
 * <p>
 * [desc]
 * @author: Klaus_gu
 * @createTime: 2020-11-03 09:47
 * @vsersion: 1.0
 **/
public interface Source {

    String OUTPUT = "output";

    @Output(Source.OUTPUT)
    MessageChannel output();
}
