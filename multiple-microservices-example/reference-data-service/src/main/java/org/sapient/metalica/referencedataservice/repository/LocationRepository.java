package org.sapient.metalica.referencedataservice.repository;

import org.sapient.metalica.referencedataservice.model.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends MongoRepository<Location, String> {

}
