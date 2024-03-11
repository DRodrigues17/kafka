package com.drodrigues17.kafkaobjectproducer.controller;

import com.drodrigues17.kafkaobjectproducer.model.Jogo;
import com.drodrigues17.kafkaobjectproducer.model.Periferico;
import com.drodrigues17.kafkaobjectproducer.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/producer")
public class ProducerController {

  private final ProducerService service;

  @PostMapping("/perifericos")
  public ResponseEntity<?> enviarMensagem(@RequestBody Periferico periferico) {
    service.enviarMensagemParaTopico(periferico);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
  @PostMapping("/jogos")
  public ResponseEntity<?> enviarMensagem(@RequestBody Jogo jogo){
    service.enviarMensagemParaTopico(jogo);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
