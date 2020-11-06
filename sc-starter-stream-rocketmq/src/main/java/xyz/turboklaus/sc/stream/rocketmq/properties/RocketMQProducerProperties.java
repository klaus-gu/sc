package xyz.turboklaus.sc.stream.rocketmq.properties;

import lombok.Data;

/**
 * @author Turbo Klaus
 * @author <a href="mailto:guyue375@outlook.com">klaus</a>
 * @program sc
 * 生产者参数参考mq的参数
 **/
@Data
public class RocketMQProducerProperties {

    private Boolean enabled = true;

    private String group;

    private Integer maxMessageSize = 1024 * 1024 * 4;

    private Boolean transactional = false;

    private Boolean sync = false;

    private Boolean vipChannelEnabled = true;

    private int sendMessageTimeout = 3000;

    private int compressMessageBodyThreshold = 1024 * 4;

    private int retryTimesWhenSendFailed = 2;

    private int retryTimesWhenSendAsyncFailed = 2;

    private boolean retryNextServer = false;
}
