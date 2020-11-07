package xyz.turboklaus.stream.tags.sample.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

/**
 * @author Turbo Klaus
 * @author <a href="mailto:guyue375@outlook.com">klaus</a>
 * @program sc
 * 自定义bindings
 **/
public interface CustomeSink {

    @Input("input1")
    MessageChannel input1();

    @Input("input2")
    MessageChannel input2();

    @Input("input3")
    MessageChannel input3();
}
