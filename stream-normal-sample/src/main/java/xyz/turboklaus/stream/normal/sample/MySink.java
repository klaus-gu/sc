package xyz.turboklaus.stream.normal.sample;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

/**
 * @author Turbo Klaus
 * @author <a href="mailto:guyue375@outlook.com">klaus</a>
 * @program sc
 **/
public interface MySink {
    String MY_SINK="my-sink";

    @Input(MySink.MY_SINK)
    MessageChannel myInput();
}
