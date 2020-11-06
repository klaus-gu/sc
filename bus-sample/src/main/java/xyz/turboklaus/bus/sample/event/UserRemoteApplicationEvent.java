package xyz.turboklaus.bus.sample.event;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;
import xyz.turboklaus.bus.sample.model.User;

/**
 * @program: sc
 * <p>
 * [desc]
 * @author: Klaus_gu
 * @createTime: 2020-11-04 22:31
 * @vsersion: 1.0
 **/
public class UserRemoteApplicationEvent extends RemoteApplicationEvent {

    private User user;

    public UserRemoteApplicationEvent() {
    }

    public UserRemoteApplicationEvent(Object source, User user, String originService,
                                      String destinationService) {
        super(source, originService, destinationService);
        this.user = user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
