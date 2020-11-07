package xyz.turboklaus.bus.sample.subscribe;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import xyz.turboklaus.bus.sample.event.UserRemoteApplicationEvent;

/**
 * @author Turbo Klaus
 * @author <a href="mailto:guyue375@outlook.com">klaus</a>
 * @program sc
 **/
@Component
public class SpringListener implements ApplicationListener<UserRemoteApplicationEvent> {

    @Override
    public void onApplicationEvent(UserRemoteApplicationEvent userRemoteApplicationEvent) {
        System.out.println("Get Message By Spring : " + userRemoteApplicationEvent.getUser().toString());
    }
}
