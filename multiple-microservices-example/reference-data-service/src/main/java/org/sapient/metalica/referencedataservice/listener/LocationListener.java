package org.sapient.metalica.referencedataservice.listener;

import org.sapient.metalica.referencedataservice.model.Location;
import org.sapient.metalica.referencedataservice.repository.LocationRepository;
import org.sapient.metalica.referencedataservice.util.CommonUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;

import static org.sapient.metalica.referencedataservice.constant.Constants.LOCATION_DATA_QUEUE;

public class LocationListener {

    @Resource LocationRepository locationRepository;

    @RabbitListener(queues = LOCATION_DATA_QUEUE)
    public Collection<Location> getLocations(String code) {
        if (CommonUtil.isEmpty(code)) {
            return locationRepository.findAll();
        }
        return Collections.singletonList(locationRepository.findOne(code));
    }


}
