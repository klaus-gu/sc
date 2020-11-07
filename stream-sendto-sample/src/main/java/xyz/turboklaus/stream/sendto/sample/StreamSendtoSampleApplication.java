package xyz.turboklaus.stream.sendto.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

/**
 * @author Turbo Klaus
 * @author <a href="mailto:guyue375@outlook.com">klaus</a>
 * @program sc
 * 消息回执/转发等
 **/
@SpringBootApplication
@EnableBinding({Source.class, Sink.class})
public class StreamSendtoSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamSendtoSampleApplication.class, args);
    }

    public static final String SENT_TO_INPUT = "send-to-output";

    /**
     * 注意，类似于这种转发，你是不是没有在配置文件里面看见"splitter-output"这个bindings
     * 所以你得在binder上给他定义这么一条通道，除非你在配置文件里面配置了
     * @return
     */
    @Bean(StreamSendtoSampleApplication.SENT_TO_INPUT)
    public MessageChannel msgChannel() {
        return new DirectChannel();
    }

    @Bean
    public Runner runner() {
        return new Runner();
    }

    public static class Runner implements CommandLineRunner {

        @Autowired
        private Source source;

        @Override
        public void run(String... args) throws Exception {
            int count = 5;
            for (int index = 1; index <= count; index++) {
                source.output().send(MessageBuilder.withPayload("sendto-msg-" + index)
                        .setHeader("index", index).build());
            }
        }
    }
}
