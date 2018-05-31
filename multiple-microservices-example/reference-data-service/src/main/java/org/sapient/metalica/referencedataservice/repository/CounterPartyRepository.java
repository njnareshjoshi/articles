package org.sapient.metalica.referencedataservice.repository;

import org.sapient.metalica.referencedataservice.model.CounterParty;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterPartyRepository extends MongoRepository<CounterParty, String> {

}
