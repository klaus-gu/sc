package xyz.turboklaus.stream.transform.sample;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

/**
 * @author Turbo Klaus
 * @author <a href="mailto:guyue375@outlook.com">klaus</a>
 * @program sc
 **/
@Component
public class TransformService {

    @StreamListener(StreamTransformSampleApplication.TRANSFORMER_INPUT)
    public void receiveTransformerMsg(String receiveMsg) {
        System.out.println("获取转换后的消息 : " + receiveMsg);
    }

    /**
     *
     * @param receiveMsg
     * @return
     */
    @Transformer(inputChannel = Sink.INPUT, outputChannel = StreamTransformSampleApplication.TRANSFORMER_INPUT)
    public String receiveByTransformer(String receiveMsg) {
        return "transformed ==>> (" + receiveMsg + ")";
    }
}
