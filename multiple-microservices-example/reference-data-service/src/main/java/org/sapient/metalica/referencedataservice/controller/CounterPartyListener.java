package org.sapient.metalica.referencedataservice.controller;

import org.sapient.metalica.referencedataservice.model.CounterParty;
import org.sapient.metalica.referencedataservice.repository.CounterPartyRepository;
import org.sapient.metalica.referencedataservice.util.CommonUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;

import static org.sapient.metalica.referencedataservice.constants.Constants.COUNTER_PARTY_DATA_QUEUE;

@RestController
@RequestMapping("/api/counterParty")
public class CounterPartyListener {

    @Resource
    CounterPartyRepository counterPartyRepository;

    @RabbitListener(queues = COUNTER_PARTY_DATA_QUEUE)
    public Collection<CounterParty> getCounterParties(String code) {
        if (CommonUtil.isEmpty(code)) {
            return counterPartyRepository.findAll();
        }
        return Collections.singletonList(counterPartyRepository.findOne(code));
    }

}
