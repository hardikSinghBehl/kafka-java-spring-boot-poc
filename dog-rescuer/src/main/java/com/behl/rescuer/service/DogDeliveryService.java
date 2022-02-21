package com.behl.rescuer.service;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.behl.rescuer.dto.Dog;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DogDeliveryService {

	private final KafkaTemplate<Null, String> kafkaTemplate;

	public void deliver(final Dog dog) {
		kafkaTemplate.sendDefault(dog.toString());
	}

}
