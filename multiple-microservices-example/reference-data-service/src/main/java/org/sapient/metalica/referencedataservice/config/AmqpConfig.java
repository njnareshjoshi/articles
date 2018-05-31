package org.sapient.metalica.referencedataservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.sapient.metalica.referencedataservice.constant.Constants.*;

@EnableRabbit
@Configuration
public class AmqpConfig {

    @Bean
    public DirectExchange commodityExchange() {
        return new DirectExchange(REF_DATA_EXCHANGE);
    }

    @Bean
    public Queue commodityDataQueue() {
        return new Queue(COMMODITY_DATA_QUEUE);
    }

    @Bean
    public Queue counterPartyDataQueue() {
        return new Queue(COUNTER_PARTY_DATA_QUEUE);
    }

    @Bean
    public Queue locationDataQueue() {
        return new Queue(LOCATION_DATA_QUEUE);
    }


    @Bean
    public Binding commodityDataQueueBinding(DirectExchange commodityExchange, Queue commodityDataQueue) {
        return BindingBuilder.bind(commodityDataQueue).to(commodityExchange).with(COMMODITY_DATA_QUEUE);
    }

    @Bean
    public Binding counterPartyDataQueueBinding(DirectExchange commodityExchange, Queue counterPartyDataQueue) {
        return BindingBuilder.bind(counterPartyDataQueue).to(commodityExchange).with(COUNTER_PARTY_DATA_QUEUE);
    }

    @Bean
    public Binding locationDataQueueBinding(DirectExchange commodityExchange, Queue locationDataQueue) {
        return BindingBuilder.bind(locationDataQueue).to(commodityExchange).with(LOCATION_DATA_QUEUE);
    }

}