package com.example.message;
 
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;



@Slf4j
@Component
//@RocketMQMessageListener(topic = "topic",consumerGroup = "consumer-group")
public class RocketMqListener implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        log.info("message = {}", message);

    }
}