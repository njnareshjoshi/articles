package org.sapient.metalica.tradeservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.core.ParameterizedTypeReference;

public class TypeAwareRabbitTemplate extends RabbitTemplate {

    private final ObjectMapper mapper = new ObjectMapper();

    public TypeAwareRabbitTemplate() {
        super();
    }

    public TypeAwareRabbitTemplate(ConnectionFactory connectionFactory) {
        super(connectionFactory);
    }

    public <T> T convertSendAndReceive(String exchange, String routingKey, Object message, ParameterizedTypeReference<T> responseType) {
        Message reply = convertSendAndReceiveRaw(exchange, routingKey, message, null, null);
        if (reply == null) {
            return null;
        }
        try {
            return mapper.readValue(reply.getBody(), mapper.getTypeFactory().constructType(responseType.getType()));
        } catch (Exception ex) {
            throw new RuntimeException("Exception while translating message");
        }
    }

}