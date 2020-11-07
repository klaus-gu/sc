package xyz.turboklaus.stream.tags.sample;

import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.support.MessageBuilder;
import xyz.turboklaus.stream.tags.sample.sink.CustomeSink;

/**
 * @author Turbo Klaus
 * @author <a href="mailto:guyue375@outlook.com">klaus</a>
 * @program sc
 **/
@SpringBootApplication
@EnableBinding({ Source.class, CustomeSink.class })
public class StreamTagsSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamTagsSampleApplication.class, args);
    }

    @Bean
    public Runner runner(){
        return new Runner();
    }

    public static class Runner implements CommandLineRunner {

        @Autowired
        private Source source;

        @Override
        public void run(String... args) throws Exception {
            int count = 5;
            for (int index = 1; index <= count; index++) {
                /**
                 * 构建消息
                 */
                MessageBuilder builder = MessageBuilder.withPayload("tag-test-" + index);

                /**
                 * 对于单双数分别设置标签，可类比rocketmq的标签
                 */
                if (index % 2 == 0) {
                    builder.setHeader(RocketMQHeaders.TAGS, "even");
                }
                else {
                    builder.setHeader(RocketMQHeaders.TAGS, "singular");
                }
                source.output().send(builder.build());
            }
        }
    }


}
