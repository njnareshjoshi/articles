package org.sapient.metalica.tradeservice.service;

import org.sapient.metalica.tradeservice.model.Trade;
import org.sapient.metalica.tradeservice.repository.TradeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class TradeService {

    @Resource TradeRepository tradeRepository;

    public Collection<Trade> getTrades(String id) {
        if (id == null || id.isEmpty())
            return tradeRepository.findAll();
        else {
            List<Trade> trades = new ArrayList<>(1);
            trades.add(tradeRepository.findOne(id));
            return trades;
        }
    }

    public Trade createTrade(Trade trade) {
        return tradeRepository.save(trade);
    }

    public Trade updateTrade(Trade trade) {
        return tradeRepository.save(trade);
    }

    public String deleteTrade(Trade trade) {
        tradeRepository.delete(trade);
        return trade.getId();
    }

}
