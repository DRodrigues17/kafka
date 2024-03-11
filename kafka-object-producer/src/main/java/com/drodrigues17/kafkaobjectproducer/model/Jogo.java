package com.drodrigues17.kafkaobjectproducer.model;


import java.io.Serializable;

public record Jogo(
     Long  id,
     String nome,
     String  empresaResponsavel,
     Long  quantidadeEstoque
) implements Serializable {
}
