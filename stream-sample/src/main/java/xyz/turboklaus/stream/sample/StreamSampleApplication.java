package xyz.turboklaus.stream.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import xyz.turboklaus.stream.sample.sink.MySink;

@SpringBootApplication
@EnableBinding(value = {MySink.class, Source.class})
public class StreamSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamSampleApplication.class, args);
    }
}
