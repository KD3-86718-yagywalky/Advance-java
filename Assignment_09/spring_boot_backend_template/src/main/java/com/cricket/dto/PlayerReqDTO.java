package com.cricket.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PlayerReqDTO {
	
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private Double battingAvg; 
	private Integer wicketTaken;

}
