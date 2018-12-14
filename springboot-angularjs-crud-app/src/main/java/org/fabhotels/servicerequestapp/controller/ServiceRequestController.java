package org.fabhotels.servicerequestapp.controller;

import org.fabhotels.servicerequestapp.constants.ServiceRequestStatus;
import org.fabhotels.servicerequestapp.model.ServiceRequest;
import org.fabhotels.servicerequestapp.service.ServiceRequestService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @author Naresh Joshi
 */

@RestController
@RequestMapping(value = "/api/service/request")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {GET, POST, PUT, DELETE, OPTIONS})
public class ServiceRequestController {

    @Resource
    ServiceRequestService serviceRequestService;

    @PostMapping
    public ServiceRequest save(@RequestBody @Valid ServiceRequest request) {
        return serviceRequestService.save(request);
    }

    @GetMapping("/{id}")
    public ServiceRequest getById(@PathVariable long id) {
        return serviceRequestService.getById(id);
    }

    @GetMapping("/status/{status}")
    public Collection<ServiceRequest> getByStatus(@PathVariable ServiceRequestStatus status) {
        return serviceRequestService.getByStatus(status);
    }

    @GetMapping("/customer/{customerId}")
    public Collection<ServiceRequest> getByCustomer(@PathVariable String customerId) {
        return serviceRequestService.getByCustomer(customerId);
    }

    @GetMapping
    public Collection<ServiceRequest> getAll() {
        return serviceRequestService.getAll();
    }

    @PutMapping("/solve/{id}")
    public ServiceRequest solveRequest(@PathVariable long id) {
        return serviceRequestService.solveRequest(id);
    }

}
