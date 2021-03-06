package xyz.turboklaus.stream.transform.sample;

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
 **/
@SpringBootApplication
@EnableBinding(value = {Sink.class, Source.class})
public class StreamTransformSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamTransformSampleApplication.class, args);
    }

    public static final String TRANSFORMER_INPUT = "transformer-output";

    @Bean(StreamTransformSampleApplication.TRANSFORMER_INPUT)
    public MessageChannel successChannel() {
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
                source.output().send(MessageBuilder.withPayload("transform-msg-" + index).build());
            }
        }
    }
}
