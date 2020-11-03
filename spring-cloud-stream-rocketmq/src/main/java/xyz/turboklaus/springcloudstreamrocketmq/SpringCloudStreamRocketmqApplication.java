package xyz.turboklaus.springcloudstreamrocketmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding
@SpringBootApplication
public class SpringCloudStreamRocketmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStreamRocketmqApplication.class, args);
    }

}
