package xyz.turboklaus.stream.filter.sample;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

/**
 * @author Turbo Klaus
 * @author <a href="mailto:guyue375@outlook.com">klaus</a>
 * @program sc
 **/
@Component
public class FilterService {

    @StreamListener(StreamFilterSampleApplication.DISCARD_INPUT)
    public void discardMsg(String receiveMsg) {
        System.out.println("丢弃的消息 : " + receiveMsg);
    }

    @StreamListener(StreamFilterSampleApplication.WANTED_INPUT)
    public void successMsg(String receiveMsg) {
        System.out.println("想要的信息 : " + receiveMsg);
    }

    /**
     * {@link Filter} 这个注解主要作用是从指定bindings获取消息，然后对消息进行分发
     *
     * @param receiveMsg
     * @return
     */
    @Filter(inputChannel = Sink.INPUT,
            discardChannel = StreamFilterSampleApplication.DISCARD_INPUT,
            outputChannel = StreamFilterSampleApplication.WANTED_INPUT)
    public boolean receiveByFilter(String receiveMsg) {
        String[] msgInfo = receiveMsg.split("-");
        if (Integer.parseInt(msgInfo[2]) % 2 == 0) {
            return true;
        }
        return false;
    }
}
