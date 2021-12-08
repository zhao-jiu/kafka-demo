package com.zj.study.kafkademo.handler;

import com.alibaba.fastjson.JSONObject;
import com.zj.study.kafkademo.common.MessageTopic;
import com.zj.study.kafkademo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author 赵赳
 * @since 2021/8/10 18:00
 */
@Slf4j
@Component
public class kafkaHandler {

    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public kafkaHandler(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * 发送用户信息
     *
     * @param id 用户id
     */
    public void sendMessages(String id) {
        var user = new User().setId(id).setUsername("tom" + id).setState("0");
        kafkaTemplate.send(MessageTopic.TEST_USER_TOPIC, JSONObject.toJSONString(user));
        log.info("发送消息到kafka，消息内容：{}", user);
    }

}
