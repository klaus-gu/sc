package xyz.turboklaus.bus.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;

@SpringBootApplication
@RemoteApplicationEventScan(basePackages = "xyz.turboklaus.bus.sample.subscribe")
public class BusSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusSampleApplication.class, args);
    }

}
