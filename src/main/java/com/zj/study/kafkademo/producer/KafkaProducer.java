package com.zj.study.kafkademo.producer;

import com.alibaba.fastjson.JSONObject;
import com.zj.study.kafkademo.common.MessageTopic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 赵赳
 * @since: 2021/8/10 17:13
 * @desc: 测试发送kafka消息
 */
@Slf4j
@RestController
public class KafkaProducer {

    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * 发送kafka测试消息
     *
     * @return 响应结果
     */
    @GetMapping("test")
    public String testKafka() {
        String str = new String("hello kafka!");
        kafkaTemplate.send(MessageTopic.TEST_TOPIC, JSONObject.toJSONString(str));
        log.info("发送消息到kafka，消息体：{}", str);
        return "成功发送消息到kafka";
    }


}
