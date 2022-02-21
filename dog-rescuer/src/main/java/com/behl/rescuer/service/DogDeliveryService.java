package com.behl.rescuer.service;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.behl.rescuer.dto.Dog;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DogDeliveryService {

	private final KafkaTemplate<Null, String> kafkaTemplate;

	public void deliver(final Dog dog) {
		String message = parseAsString(dog);
		kafkaTemplate.sendDefault(message).addCallback(new LogDeliveryService());
	}

	private String parseAsString(final Dog dog) {
		String message = null;
		try {
			message = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(dog);
		} catch (JsonProcessingException e) {
			new RuntimeException("Unable to deliver dog " + dog.toString(), e);
		}
		return message;
	}

}
