package com.zj.study.kafkademo.consumer;

import com.zj.study.kafkademo.common.MessageTopic;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;



/**
 * @author 赵赳
 * @since 2021/8/10 17:19
 * @desc kafka消费者
 */
@Slf4j
@Component
public class KafkaConsumer {

    /**
     * 接收TEST_TOPIC主题消息
     *
     * @param consumerRecord 消息体
     */
    @KafkaListener(topics = {MessageTopic.TEST_TOPIC})
    public void getMessages(ConsumerRecord<String, String> consumerRecord) {
        var value = consumerRecord.value();
        log.info("接收到kafka消息，消息为：{}", value);
    }

    /**
     * 接收TEST_USER_TOPIC主题消息
     *
     * @param consumerRecord 消息体
     */
    @KafkaListener(topics = {MessageTopic.TEST_USER_TOPIC})
    public void getUserMessages(ConsumerRecord<String, String> consumerRecord) {
        //判断是否为null
        var kafkaMessage = Optional.ofNullable(consumerRecord.value());
        log.info(">>>>>>>>>> record =" + kafkaMessage);
        if (kafkaMessage.isPresent()) {
            //得到Optional实例中的值
            Object message = kafkaMessage.get();
            log.info("消费kafka消息，消息为：{}", message);
        }
    }
}
