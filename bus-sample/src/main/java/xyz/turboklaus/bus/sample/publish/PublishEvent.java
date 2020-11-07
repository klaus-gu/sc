package xyz.turboklaus.bus.sample.publish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.turboklaus.bus.sample.event.UserRemoteApplicationEvent;
import xyz.turboklaus.bus.sample.model.User;

/**
 * @author Turbo Klaus
 * @author <a href="mailto:guyue375@outlook.com">klaus</a>
 * @program sc
 **/
@RestController
public class PublishEvent {

    @Autowired
    private ApplicationEventPublisher publisher;

    @Value("${spring.cloud.bus.id}")
    private String originService;

    @GetMapping("/publish")
    public boolean publish() {
        User user = new User();
        user.setId(System.currentTimeMillis());
        user.setName("zs");
        publisher.publishEvent(
                new UserRemoteApplicationEvent(this, user, originService, "bus_rocketmq"));
        return true;
    }

    @GetMapping("/publish/1")
    public boolean publish1() {
        User user = new User();
        user.setId(System.currentTimeMillis());
        user.setName("lisi");
        publisher.publishEvent(
                new UserRemoteApplicationEvent(this, user, originService, "bus_rocketmq_topic"));
        return true;
    }
}
