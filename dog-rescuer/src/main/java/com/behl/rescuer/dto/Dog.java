package com.behl.rescuer.dto;

import com.github.javafaker.Faker;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class Dog {

	private String age;
	private String breed;
	private String name;
	private String size;
	private String coatLength;
	private String gender;

	public static Dog find() {
		final var fakeDog = new Faker().dog();
		return Dog.builder().age(fakeDog.age()).breed(fakeDog.breed()).name(fakeDog.name()).size(fakeDog.size())
				.coatLength(fakeDog.coatLength()).gender(fakeDog.gender()).build();
	}

}
