package org.sapient.metalica.referencedataservice.controller;

import org.sapient.metalica.referencedataservice.model.Commodity;
import org.sapient.metalica.referencedataservice.repository.CommodityRepository;
import org.sapient.metalica.referencedataservice.util.CommonUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;

import static org.sapient.metalica.referencedataservice.constants.Constants.*;

public class CommodityListener {

    @Resource
    CommodityRepository commodityRepository;

    @RabbitListener(queues = COMMODITY_DATA_QUEUE)
    public Collection<Commodity> getCommodities(String code) {
        if (CommonUtil.isEmpty(code)) {
            return commodityRepository.findAll();
        }
        return Collections.singletonList(commodityRepository.findOne(code));
    }

}
