package org.fabhotels.servicerequestapp.service.impl;

import org.fabhotels.servicerequestapp.constants.ServiceRequestStatus;
import org.fabhotels.servicerequestapp.model.ServiceRequest;
import org.fabhotels.servicerequestapp.repository.ServiceRequestRepository;
import org.fabhotels.servicerequestapp.service.ServiceRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Collection;

import static org.fabhotels.servicerequestapp.constants.ServiceRequestStatus.RESOLVED;

/**
 * @author Naresh Joshi
 */

@Service
@Transactional
public class ServiceRequestServiceImpl implements ServiceRequestService {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource ServiceRequestRepository serviceRequestRepository;

    @Override
    public ServiceRequest save(ServiceRequest request) {
        return serviceRequestRepository.save(request);
    }

    @Override
    public ServiceRequest getById(long id) {
        return serviceRequestRepository.findOne(id);
    }

    @Override
    public Collection<ServiceRequest> getByStatus(ServiceRequestStatus status) {
        return serviceRequestRepository.findByStatus(status);
    }

    @Override
    public Collection<ServiceRequest> getByCustomer(String customerId) {
        return null;
    }

    @Override
    public Collection<ServiceRequest> getAll() {
        return serviceRequestRepository.findAll();
    }

    @Override
    public ServiceRequest solveRequest(long id) {
        ServiceRequest request = serviceRequestRepository.findOne(id);
        Assert.notNull(request, "No record found with id " + id);

        request.setStatus(RESOLVED);
        return serviceRequestRepository.save(request);
    }

}
