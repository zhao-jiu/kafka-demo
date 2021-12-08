package com.zj.study.kafkademo.producer;

import com.zj.study.kafkademo.common.MessageTopic;
import com.zj.study.kafkademo.handler.kafkaHandler;
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

  private final KafkaTemplate<String, String> kafkaTemplate;

  private final kafkaHandler kafkaHandler;

  @Autowired
  public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate,
      com.zj.study.kafkademo.handler.kafkaHandler kafkaHandler) {
    this.kafkaTemplate = kafkaTemplate;
    this.kafkaHandler = kafkaHandler;
  }

  /**
   * <h2>发送kafka测试消息<h2/>
   *
   * @return 响应结果
   */
  @GetMapping("test")
  public String testKafka() {
    String str = "hello kafka!";
    kafkaTemplate.send(MessageTopic.TEST_TOPIC, str);
    return "成功发送消息到kafka";
  }

  /**
   * <h2>发送kafka测试消息<h2/>
   *
   * @return 响应结果
   */
  @GetMapping("user")
  public String testKafkaSendEntity() {
    for (int i = 0; i < 10; i++) {
      kafkaHandler.sendMessages(String.valueOf(++i));
    }
    return "成功发送消息到kafka";
  }


}
