package xyz.turboklaus.stream.tags.sample.listener;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @author Turbo Klaus
 * @author <a href="mailto:guyue375@outlook.com">klaus</a>
 * @program sc
 **/
@Component
public class TagService {

    /**
     * 监听带有singular标签的消息
     * @param receiveMsg
     */
    @StreamListener("input1")
    public void receiveOrderMsg(String receiveMsg) {
        System.out.println("[ input 1 ] 获取 单数 => " + receiveMsg);
    }

    /**
     * 监听带有even标签的消息
     * @param receiveMsg
     */
    @StreamListener("input2")
    public void receivePayMsg(String receiveMsg) {
        System.out.println("[ input 22 ] 获取 双数 ==>> " + receiveMsg);
    }

    /**
     * 监听所有消息
     * @param receiveMsg
     */
    @StreamListener("input3")
    public void receivePayAndOrderMsg(String receiveMsg) {
        System.out.println("[ input 333 ] 获取 所有 ===>>> " + receiveMsg);
    }

}
