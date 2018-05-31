package org.sapient.metalica.tradeservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.sapient.metalica.tradeservice.constant.Constants.*;

@Configuration
public class AmqpConfig {

    @Bean("tradeExchange")
    public DirectExchange tradeExchange() {
        return new DirectExchange(TRADE_EXCHANGE);
    }

    @Bean("tradeDataQueue")
    public Queue tradeDataQueue() {
        return new Queue(TRADE_DATA_GET_QUEUE);
    }

    @Bean("tradeCreateQueue")
    public Queue tradeCreateQueue() {
        return new Queue(TRADE_CREATE_QUEUE);
    }

    @Bean("tradeUpdateQueue")
    public Queue tradeUpdateQueue() {
        return new Queue(TRADE_UPDATE_QUEUE);
    }

    @Bean("tradeDeleteQueue")
    public Queue tradeDeleteQueue() {
        return new Queue(TRADE_DELETE_QUEUE);
    }


    @Bean("tradeDataQueueBinding")
    public Binding tradeDataQueueBinding(@Qualifier("tradeDataQueue") Queue tradeDataQueue, DirectExchange tradeExchange) {
        return BindingBuilder.bind(tradeDataQueue).to(tradeExchange).withQueueName();
    }

    @Bean("tradeCreateQueueBinding")
    public Binding tradeCreateQueueBinding(@Qualifier("tradeCreateQueue") Queue tradeCreateQueue, DirectExchange tradeExchange) {
        return BindingBuilder.bind(tradeCreateQueue).to(tradeExchange).withQueueName();
    }

    @Bean("tradeUpdateQueueBinding")
    public Binding tradeUpdateQueueBinding(@Qualifier("tradeUpdateQueue") Queue tradeUpdateQueue, DirectExchange tradeExchange) {
        return BindingBuilder.bind(tradeUpdateQueue).to(tradeExchange).withQueueName();
    }

    @Bean("tradeDeleteQueueBinding")
    public Binding tradeDeleteQueueBinding(@Qualifier("tradeDeleteQueue") Queue tradeDeleteQueue, DirectExchange tradeExchange) {
        return BindingBuilder.bind(tradeDeleteQueue).to(tradeExchange).withQueueName();
    }

    @Bean
    public Queue hello() {
        return new Queue("hello");
    }

}