package com.drodrigues17.kafkaobjectproducer.service;

import com.drodrigues17.kafkaobjectproducer.model.Jogo;
import com.drodrigues17.kafkaobjectproducer.model.Periferico;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProducerService {

  private final KafkaTemplate<String, Serializable> kafkaTemplate;

  public void enviarMensagemParaTopico(Jogo jogo){
    kafkaTemplate.send("object-topic", jogo).whenComplete((resultado, ex) -> {
      if (ex == null) {
        log.info("jogo '{}' enviado com sucesso na partição '{}' com o offset '{}'"
            , jogo
            , resultado.getRecordMetadata().partition()
            , resultado.getRecordMetadata().offset());
      } else {
        log.error("não foi possível enviar o jogo {}", jogo);
      }
    });

  }

  public void enviarMensagemParaTopico(Periferico periferico){
    kafkaTemplate.send("object-topic", periferico).whenComplete((resultado, ex) -> {
      if (ex == null) {
        log.info("periférico '{}' enviado com sucesso na partição '{}' com o offset '{}'"
            , periferico
            , resultado.getRecordMetadata().partition()
            , resultado.getRecordMetadata().offset());
      } else {
        log.error("não foi possível enviar o periférico {}", periferico);
      }
    });

  }

}
