package com.drodrigues17.kafkaconsumer.listener;

import com.drodrigues17.kafkaconsumer.helper.KafkaHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import static org.awaitility.Awaitility.setDefaultPollInterval;
import static org.awaitility.Awaitility.setDefaultTimeout;
import static org.awaitility.Durations.FIVE_SECONDS;
import static org.awaitility.Durations.TEN_SECONDS;
import static org.junit.jupiter.api.Assertions.assertNull;

class KafkaListenerTest extends KafkaHelper {

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  private KafkaListener kafkaListener;

  @BeforeEach
  void setup() {

    setDefaultTimeout(TEN_SECONDS);
    setDefaultPollInterval(FIVE_SECONDS);
  }

  @Test
  void deveConsumirEventoComSucesso() {
    String mensagemProTopico = "mensagem de teste";

    kafkaTemplate.send("str-topic", mensagemProTopico)
        .whenComplete((stringStringSendResult, throwable) -> assertNull(throwable));


    Mockito.spy(KafkaListener.class).listener(mensagemProTopico);

  }

}