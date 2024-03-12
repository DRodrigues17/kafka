package com.drodrigues17.kafkaobjectconsumer.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Nessa interface estamos criando uma anotação para implementar a anotação padrão do kafkaListener,
 * onde definiremos valores padrão para o container factory e o tópico do listener.
 * <p>
 * A anotação @Retention(RetentionPolicy.RUNTIME) permite sinalizar ao spring que essa anotação que estamos
 * criando deve estar disponível em tempo de execução.
 * <p>
 * A anotação @Target(ElementType) permite sinalizar aonde essa anotação pode ser usada, nesse caso
 * estamos usando o ElementType.METHOD para dizer que essa anotação se aplica a métodos.
 * <p>
 * A anotação @AliasFor permite definirmos qual campo da anotação queremos implementar, um exemplo é o grupo,
 * pegamos o campo "groupId" da anotação original e definimos que se quisermos passar um novo para esse campo
 * precisaremos enviar para o campo grupo.
 * */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@KafkaListener
public @interface KafkaListenerCustomizado {

  @AliasFor(annotation =  KafkaListener.class, attribute = "topics")
  String[] topicos() default "object-topic";

  @AliasFor(annotation =  KafkaListener.class, attribute = "containerFactory")
  String containerFactory() default "kafkaContainerFactory";

  @AliasFor(annotation =  KafkaListener.class, attribute = "groupId")
  String grupo() default "";

  @AliasFor(annotation =  KafkaListener.class, attribute = "errorHandler")
  String errorHandler() default "exceptionHandler";
  @AliasFor(annotation =  KafkaListener.class, attribute = "topicPartitions")
  TopicPartition[] particoes() default { @TopicPartition(topic = "object-topic", partitions = {"0"} )};
}
