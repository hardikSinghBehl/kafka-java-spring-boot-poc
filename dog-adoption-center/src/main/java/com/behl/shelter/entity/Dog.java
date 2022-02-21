package com.behl.shelter.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "dogs")
@Data
public class Dog implements Serializable {

	private static final long serialVersionUID = 7472162416159007816L;

	@Id
	private UUID id;

	private String age;
	private String breed;
	private String name;
	private String size;
	private String coatLength;
	private String gender;
	private LocalDateTime rescuedAt;
	private LocalDateTime deliveredAt;

	@PrePersist
	void setUp() {
		this.deliveredAt = LocalDateTime.now(ZoneId.of("+00:00"));
	}

}
