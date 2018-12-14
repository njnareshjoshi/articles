package org.fabhotels.servicerequestapp.repository;

import org.fabhotels.servicerequestapp.constants.ServiceRequestStatus;
import org.fabhotels.servicerequestapp.model.ServiceRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author Naresh Joshi
 */
@Repository
public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> {

    Collection<ServiceRequest> findByStatus(ServiceRequestStatus status);

}
