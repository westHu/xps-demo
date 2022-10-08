package com.example.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * https://blog.csdn.net/qq_26154077/article/details/111013842
 * https://blog.csdn.net/weixin_42029738/article/details/119010985
 *
 * 加上配置
 *rocketmq:
 *   name-server: 127.0.0.1:9876
 *   producer:
 *       group: my-producer-group
 */


@Slf4j
@Component
public class RocketMqProducer {

//    @Resource
//    private RocketMQTemplate rocketMQTemplate;

    public void send() {
//        rocketMQTemplate.convertAndSend("topic","message");
    }

}
