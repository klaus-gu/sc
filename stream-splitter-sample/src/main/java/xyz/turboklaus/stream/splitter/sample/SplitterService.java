package xyz.turboklaus.stream.splitter.sample;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.Splitter;
import org.springframework.stereotype.Component;

/**
 * @author Turbo Klaus
 * @author <a href="mailto:guyue375@outlook.com">klaus</a>
 * @program sc
 **/
@Component
public class SplitterService {

    /**
     * 监听
     * @param receiveMsg
     */
    @StreamListener(StreamSplitterSampleApplication.SPLITTER_INPUT)
    public void receiveTransformerMsg(String receiveMsg) {
        System.out.println("收到分开后的消息 : " + receiveMsg);
    }

    /**
     * 由{@link Splitter}注解，接受topic里面的消息，将其处理之后，再转发到outputChannel这个bindings
     * @param receiveMsg
     * @return
     */
    @Splitter(inputChannel = Sink.INPUT, outputChannel = StreamSplitterSampleApplication.SPLITTER_INPUT)
    public String[] receiveBySplitter(String receiveMsg) {
        return receiveMsg.split("-");
    }
}
