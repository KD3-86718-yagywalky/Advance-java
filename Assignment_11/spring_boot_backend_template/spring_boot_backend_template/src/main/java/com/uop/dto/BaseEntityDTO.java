package com.uop.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BaseEntityDTO {
	
	private Long id;

	private LocalDate createdOn;

	private LocalDateTime updatedOn;

}
