package com.drodrigues17.kafkaobjectproducer.model;


import lombok.Getter;

import java.io.Serializable;

@Getter
public class Periferico implements Serializable {
  private Long  id;
  private String nome;
  private Long  numeroSerie;
  private Long  quantidadeEstoque;
}
