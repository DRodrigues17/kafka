package com.drodrigues17.kafkaconsumer.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ExceptionHandler implements KafkaListenerErrorHandler {
  /**
   * Handle the error.
   *
   * @param message   the spring-messaging message.
   * @param exception the exception the listener threw, wrapped in a
   *                  {@link ListenerExecutionFailedException}.
   * @return the return value is ignored unless the annotated method has a
   * {@code @SendTo} annotation.
   */
  @Override
  public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
    log.info("erro ao tentar consumir do tópico " + message.getHeaders().get("kafka_receivedTopic"));
    log.info("payload da mensagem : " + message.getPayload());
    log.info("headers da mensagem : " + message.getHeaders());
    return null;
  }


}
