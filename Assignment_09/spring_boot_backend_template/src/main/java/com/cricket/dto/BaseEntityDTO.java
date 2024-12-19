package com.cricket.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BaseEntityDTO {
	
	private Long id;
	private LocalDate createdOn;
	private LocalDateTime updatedOn;
	
}
