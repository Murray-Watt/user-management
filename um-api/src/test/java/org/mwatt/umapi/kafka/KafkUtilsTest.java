package org.mwatt.umapi.kafka;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mwatt.umapi.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {Application.class})
public class KafkUtilsTest {
    @Autowired
    private KafkaUtils kafkaUtils;

    @Test
    public void sendMessageTest() {
        kafkaUtils.sendMessage("test-topic", "Hello, world!");
    }
}
