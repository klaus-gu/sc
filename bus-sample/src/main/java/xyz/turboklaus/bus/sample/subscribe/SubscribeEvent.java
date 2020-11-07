package xyz.turboklaus.bus.sample.subscribe;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.bus.event.AckRemoteApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import xyz.turboklaus.bus.sample.event.UserRemoteApplicationEvent;

/**
 * @author Turbo Klaus
 * @author <a href="mailto:guyue375@outlook.com">klaus</a>
 * @program sc
 **/
@Component
public class SubscribeEvent {

    @Value("${server.port}")
    private int localServerPort;

    @Autowired
    private ObjectMapper objectMapper;

    @EventListener
    public void onEvent(UserRemoteApplicationEvent event) {
        System.out.printf("Server [port : %d] listeners on %s\n", localServerPort,
                event.getUser());
    }

    @EventListener(AckRemoteApplicationEvent.class)
    public void onAckEvent(AckRemoteApplicationEvent event)
            throws JsonProcessingException {
        System.out.printf("Server [port : %d] listeners on %s\n", localServerPort,
                objectMapper.writeValueAsString(event));
    }
}
