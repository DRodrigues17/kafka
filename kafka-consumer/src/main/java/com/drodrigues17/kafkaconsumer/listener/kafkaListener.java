package com.drodrigues17.kafkaconsumer.listener;

import com.drodrigues17.kafkaconsumer.custom.KafkaListenerCustomizado;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class kafkaListener {


  @KafkaListenerCustomizado(
      grupo = "grupo-1")
  public void listener(String mensagem) {
    log.info("mensagem '{}' recebida com sucesso", mensagem);
    throw  new RuntimeException();
  }

}
