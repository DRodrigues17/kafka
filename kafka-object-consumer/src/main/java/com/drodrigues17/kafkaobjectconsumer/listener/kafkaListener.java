package com.drodrigues17.kafkaobjectconsumer.listener;

import com.drodrigues17.kafkaobjectconsumer.annotation.KafkaListenerCustomizado;
import com.drodrigues17.kafkaobjectconsumer.model.Jogo;
import com.drodrigues17.kafkaobjectconsumer.model.Periferico;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class kafkaListener {


  @KafkaListenerCustomizado
  public void listener(@Payload Jogo jogo) {
    log.info("jogo '{}' recebido com sucesso", jogo);
  }

  @KafkaListenerCustomizado(particoes = {@TopicPartition(topic = "object-topic", partitions = {"1"})})
  public void listener(@Payload Periferico periferico) {
    log.info("periferico '{}' recebido com sucesso", periferico);
  }

}
