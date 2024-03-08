package com.drodrigues17.kafkaproducer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class StringProducerService {

  private final KafkaTemplate<String, String> kafkaTemplate;

  public void enviarMensagemParaTopico(String mensagem){
    kafkaTemplate.send("str-topic", mensagem).whenComplete((resultado, ex) -> {
      if (ex == null) {
        log.info("mensagem '{}' enviada com sucesso na partição '{}' com o offset '{}'"
            , mensagem
            , resultado.getRecordMetadata().partition()
            , resultado.getRecordMetadata().offset());
      } else {
        log.error("não foi possivel enviar a menagem {}", mensagem);
      }
    });

  }

}
