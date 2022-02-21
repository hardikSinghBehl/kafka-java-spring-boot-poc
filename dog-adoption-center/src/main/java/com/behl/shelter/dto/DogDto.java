package com.behl.shelter.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
@ToString
public class DogDto {

	private UUID id;
	private String age;
	private String breed;
	private String name;
	private String size;
	private String coatLength;
	private String gender;
	private LocalDateTime rescuedAt;
	private LocalDateTime deliveredAt;

}
