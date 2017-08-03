package com.activiti.common.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.Optional;

/**
 * kafka 消费者监听器
 * Created by liulinhui on 2017/8/3.
 */

public class Listener {
    private final Logger logger = LoggerFactory.getLogger(Listener.class);

    @KafkaListener(topics = {"FUCKING_TEST"})
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            logger.info("收到数据 " + message);
        }
    }
}
