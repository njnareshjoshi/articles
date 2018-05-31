package org.sapient.metalica.referencedataservice.controller;

import org.sapient.metalica.referencedataservice.model.Location;
import org.sapient.metalica.referencedataservice.repository.LocationRepository;
import org.sapient.metalica.referencedataservice.util.CommonUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;

import static org.sapient.metalica.referencedataservice.constants.Constants.LOCATION_DATA_QUEUE;

@RestController
@RequestMapping("/api/location")
public class LocationListener {

    @Resource
    LocationRepository locationRepository;

    @RabbitListener(queues = LOCATION_DATA_QUEUE)
    public Collection<Location> getLocations(String code) {
        if (CommonUtil.isEmpty(code)) {
            return locationRepository.findAll();
        }
        return Collections.singletonList(locationRepository.findOne(code));
    }


}
