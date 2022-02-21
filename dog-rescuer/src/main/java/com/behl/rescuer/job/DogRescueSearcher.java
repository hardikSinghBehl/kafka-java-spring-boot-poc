package com.behl.rescuer.job;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.behl.rescuer.DogDeliveryService;
import com.behl.rescuer.dto.Dog;

import lombok.AllArgsConstructor;

@Configuration
@EnableScheduling
@AllArgsConstructor
public class DogRescueSearcher {

	private final DogDeliveryService dogDeliveryService;

	@Scheduled(fixedRate = 2000)
	public void search() {
		final var dog = Dog.find();
		dogDeliveryService.deliver(dog);
	}

}
