package com.behl.shelter.consumer;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import com.behl.shelter.dto.DogDto;
import com.behl.shelter.entity.Dog;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@AllArgsConstructor
@Slf4j
public class RescuedDogDeliveryReceiver {

	private final EntityManager entityManager;

	@Transactional
	@KafkaListener(topics = "rescued-dogs-delivery", concurrency = "3")
	public void listen(ConsumerRecord<String, String> record) {
		final var rescuedDeliveredDog = parseFromString(record);

		final var dog = buildEntity(rescuedDeliveredDog);
		entityManager.persist(dog);

		log.info("Successfully saved {}", record.value());
	}

	private Dog buildEntity(final DogDto rescuedDeliveredDog) {
		final var dog = new ModelMapper().map(rescuedDeliveredDog, Dog.class);
		return dog;
	}

	private DogDto parseFromString(final ConsumerRecord<String, String> record) {
		try {
			return new ObjectMapper().registerModule(new JavaTimeModule()).readValue(record.value(), DogDto.class);
		} catch (final JsonProcessingException exception) {
			throw new RuntimeException("Unable to parse message " + record.value(), exception);
		}
	}

}
