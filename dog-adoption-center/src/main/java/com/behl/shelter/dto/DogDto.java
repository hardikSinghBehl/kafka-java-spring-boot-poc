package com.behl.shelter.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class DogDto {

	private String age;
	private String breed;
	private String name;
	private String size;
	private String coatLength;
	private String gender;
	private LocalDateTime rescuedAt;

}
