package com.behl.shelter.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

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

	@GetMapping(value = "/dogs", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Dog>> dogListRetreivalHandler() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Dog> criteriaQuery = criteriaBuilder.createQuery(Dog.class);
		CriteriaQuery<Dog> dogsListQuery = criteriaQuery.select(criteriaQuery.from(Dog.class));
		final List<Dog> dogs = entityManager.createQuery(dogsListQuery).getResultList();
		return ResponseEntity.ok(dogs);
	}

}
