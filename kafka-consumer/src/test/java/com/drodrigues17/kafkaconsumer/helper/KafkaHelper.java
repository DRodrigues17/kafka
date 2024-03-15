package com.drodrigues17.kafkaconsumer.helper;

import com.drodrigues17.kafkaconsumer.KafkaConsumerApplication;
import com.drodrigues17.kafkaconsumer.config.StringConsumerConfig;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest(classes = {KafkaConsumerApplication.class, StringConsumerConfig.class})
@EmbeddedKafka(
    topics = {"str-topic"},
    partitions = 1,
    bootstrapServersProperty = "spring.kafka.bootstrap-servers"
)
@DirtiesContext
public class KafkaHelper {
}
