package com.drodrigues17.kafkaproducer.controller;

import com.drodrigues17.kafkaproducer.service.StringProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/producer")
public class StringProducerController {

  private final StringProducerService service;

  @PostMapping()
  public ResponseEntity<?> enviarMensagem(@RequestParam String mensagem){
    service.enviarMensagemParaTopico(mensagem);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
