package org.fabhotels.servicerequestapp.service;

import org.fabhotels.servicerequestapp.constants.ServiceRequestStatus;
import org.fabhotels.servicerequestapp.model.ServiceRequest;

import java.util.Collection;

/**
 * @author Naresh Joshi
 */
public interface ServiceRequestService {

    ServiceRequest save(ServiceRequest request);

    ServiceRequest getById(long id);

    Collection<ServiceRequest> getByStatus(ServiceRequestStatus status);

    Collection<ServiceRequest> getByCustomer(String customerId);

    Collection<ServiceRequest> getAll();

    ServiceRequest solveRequest(long id);

}
