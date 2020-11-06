package xyz.turboklaus.stream.sample.sink;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    @StreamListener(MySink.HELLO)
    public void consume(String message) {
        log.info("接受消息：" + message);
    }
}
