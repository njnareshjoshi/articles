package org.sapient.metalica.tradeservice.repository;

import org.sapient.metalica.tradeservice.model.Trade;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeRepository extends MongoRepository<Trade, String>, QueryDslPredicateExecutor<Trade> {
}
