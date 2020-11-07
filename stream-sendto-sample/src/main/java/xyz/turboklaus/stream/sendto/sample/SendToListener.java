package xyz.turboklaus.stream.sendto.sample;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @author Turbo Klaus
 * @author <a href="mailto:guyue375@outlook.com">klaus</a>
 * @program sc
 **/
@Component
public class SendToListener {

    /**
     * {@link SendTo} 返回消息给指定的通道
     *
     * 场景：消息反馈 / 消息处理后的转发 等
     *
     * 注意⚠️：若你需要将SendTo使用本来的bindings发送消息，那么注意bindings的流向
     * 此时使用的input应该指向原本output的destination
     *          output应该指向原本input的destination
     *
     * @param receiveMsg
     * @return
     */
    @StreamListener(Sink.INPUT)
    @SendTo(StreamSendtoSampleApplication.SENT_TO_INPUT)
    public String receive(String receiveMsg) {
        System.out.println("收到 : " + receiveMsg);
        return "经由 SendTo(" + receiveMsg + ")";
    }

    /**
     * @param receiveMsg
     */
    @StreamListener(StreamSendtoSampleApplication.SENT_TO_INPUT)
    public void receiveBySendTo(String receiveMsg) {
        System.out.println("从 SendTo 收到: " + receiveMsg);
    }
}
