package com.behl.rescuer.dto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

import com.github.javafaker.Faker;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class Dog {

	private UUID id;
	private String age;
	private String breed;
	private String name;
	private String size;
	private String coatLength;
	private String gender;
	private LocalDateTime rescuedAt;

	public static Dog find() {
		final var fakeDog = new Faker().dog();
		return Dog.builder().id(UUID.randomUUID()).age(fakeDog.age()).breed(fakeDog.breed()).name(fakeDog.name())
				.size(fakeDog.size()).coatLength(fakeDog.coatLength()).gender(fakeDog.gender())
				.rescuedAt(LocalDateTime.now(ZoneId.of("+00:00"))).build();
	}

}
