package com.behl.shelter.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.behl.shelter.entity.Dog;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class DogController {

	private final EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/dogs", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Dog>> dogListRetreivalHandler() {
		final List<Dog> dogs = entityManager.createNativeQuery("SELECT * FROM dogs").getResultList();
		return ResponseEntity.ok(dogs);
	}

}
