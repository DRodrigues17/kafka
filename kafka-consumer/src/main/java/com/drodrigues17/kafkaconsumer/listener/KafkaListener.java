package com.drodrigues17.kafkaconsumer.listener;

import com.drodrigues17.kafkaconsumer.annotation.KafkaListenerCustomizado;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaListener {


  @KafkaListenerCustomizado(grupo = "grupo-1")
  public void listener(String mensagem) {
    log.info("mensagem '{}' recebida com sucesso", mensagem);
  }

}
