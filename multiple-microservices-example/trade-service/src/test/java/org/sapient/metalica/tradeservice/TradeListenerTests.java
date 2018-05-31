package org.sapient.metalica.tradeservice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sapient.metalica.tradeservice.config.TypeAwareRabbitTemplate;
import org.sapient.metalica.tradeservice.constant.TradeSide;
import org.sapient.metalica.tradeservice.dto.RefDataDTO;
import org.sapient.metalica.tradeservice.model.Trade;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.Date;

import static org.junit.Assert.*;
import static org.sapient.metalica.tradeservice.constant.Constants.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TradeListenerTests {

    @Autowired
    TypeAwareRabbitTemplate rabbitTemplate;

    final ParameterizedTypeReference<Collection<Trade>> typeReference = new ParameterizedTypeReference<Collection<Trade>>() {
    };

    @Test
    @Before
    public void createAndFindOneTradeTest() {
        Trade trade = new Trade();
        trade.setDate(new Date());
        trade.setPrice(1000);
        trade.setQuantity(10);
        trade.setSide(TradeSide.BUY);
        trade.setCommodity(new RefDataDTO("FE", "Iron"));
        trade.setCounterParty(new RefDataDTO("LOREM", "Lorem"));
        trade.setLocation(new RefDataDTO("NYC", "New York"));

        Trade result = (Trade) rabbitTemplate.convertSendAndReceive(TRADE_EXCHANGE, TRADE_CREATE_QUEUE, trade);

        assertNotNull(result);
        assertNotNull(result.getId());

        Collection<Trade> trades = rabbitTemplate.convertSendAndReceive(TRADE_EXCHANGE, TRADE_DATA_GET_QUEUE, result.getId(), typeReference);

        assertNotNull(trades);
        assertEquals(trades.size(), 1);
        assertTrue(trades.contains(result));
    }


    @Test
    public void getTradesTest() {
        Collection<Trade> trades = rabbitTemplate.convertSendAndReceive(TRADE_EXCHANGE, TRADE_DATA_GET_QUEUE, "", typeReference);

        assertNotNull(trades);
        assertTrue(trades.size() >= 1);
    }

    public void updateTrade() {
    }

    public void deleteTrade() {
    }

}
