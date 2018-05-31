package org.sapient.metalica.referencedataservice.repository;

import org.sapient.metalica.referencedataservice.model.Commodity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommodityRepository extends MongoRepository<Commodity, String> {

}
