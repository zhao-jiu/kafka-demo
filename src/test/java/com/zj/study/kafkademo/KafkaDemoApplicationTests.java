package com.zj.study.kafkademo;

import com.zj.study.kafkademo.handler.kafkaHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KafkaDemoApplicationTests {

    kafkaHandler kafkaHandler;

    @Autowired
    public KafkaDemoApplicationTests(kafkaHandler kafkaHandler) {
        this.kafkaHandler = kafkaHandler;
    }

    @Test
    void sendMessages() {
        for (int i = 0; i < 10; i++) {
            kafkaHandler.sendMessages(String.valueOf(++i));
        }
    }

}
