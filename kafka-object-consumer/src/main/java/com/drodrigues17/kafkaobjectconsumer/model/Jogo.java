package com.drodrigues17.kafkaobjectconsumer.model;


public record Jogo(
    Long id,
    String nome,
    String empresaResponsavel,
    Long quantidadeEstoque
) {
}
