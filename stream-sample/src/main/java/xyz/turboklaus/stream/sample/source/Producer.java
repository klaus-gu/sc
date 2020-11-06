package xyz.turboklaus.stream.sample.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: sc
 * <p>
 * [desc]
 * @author: Klaus_gu
 * @createTime: 2020-11-03 20:00
 * @vsersion: 1.0
 **/
@RestController
public class Producer {

    @Autowired
    private Source source;

    @GetMapping(value = "/send")
    public void orderly() {
        for (int i = 0; i < 10; i++) {
            source.output().send(MessageBuilder.withPayload("hello").build());
        }
    }

}
