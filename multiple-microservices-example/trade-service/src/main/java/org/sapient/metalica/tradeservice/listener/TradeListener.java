package org.sapient.metalica.tradeservice.listener;

import org.sapient.metalica.tradeservice.model.Trade;
import org.sapient.metalica.tradeservice.service.TradeService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Collection;

import static org.sapient.metalica.tradeservice.constant.Constants.*;

@Controller
public class TradeListener {

    @Resource TradeService tradeService;

    @RabbitListener(queues = TRADE_DATA_GET_QUEUE)
    public Collection<Trade> getTrades(String id) {
        return tradeService.getTrades(id);
    }

    @RabbitListener(queues = TRADE_CREATE_QUEUE)
    public Trade createTrade(@Payload Trade trade) {
        return tradeService.createTrade(trade);
    }

    @RabbitListener(queues = TRADE_UPDATE_QUEUE)
    public Trade updateTrade(@Payload Trade trade) {
        return tradeService.updateTrade(trade);
    }

    @RabbitListener(queues = TRADE_DELETE_QUEUE)
    public String deleteTrade(@Payload Trade trade) {
        return tradeService.deleteTrade(trade);
    }

}
