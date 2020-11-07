package xyz.turboklaus.stream.normal.sample;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageHeaders;
import org.springframework.util.MimeTypeUtils;

/**
 * @author Turbo Klaus
 * @author <a href="mailto:guyue375@outlook.com">klaus</a>
 * @program sc
 **/
@SpringBootApplication
@EnableBinding({Source.class, Sink.class})
public class StreamNormalSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamNormalSampleApplication.class, args);
    }

    @Bean
    public Runner runner() {
        return new Runner();
    }

    public static class Runner implements CommandLineRunner {

        @Autowired
        private Source source;

        private ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public void run(String... args) throws Exception {
            int count = 5;
            for (int index = 1; index <= count; index++) {
                source.output().send(MessageBuilder.withPayload("msg-" + index)
                        .setHeader("age", index).build());
            }
            source.output().send(MessageBuilder
                    .withPayload(objectMapper.writeValueAsString(new User("lisi", 33)))
                    .setHeader("age", 33)
                    .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                    .build());
        }
    }

}
