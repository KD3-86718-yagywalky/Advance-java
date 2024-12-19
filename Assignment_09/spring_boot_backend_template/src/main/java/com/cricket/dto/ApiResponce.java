package com.cricket.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ApiResponce {
	
	private String massege;
	private LocalDateTime timeStamp;
	
	public ApiResponce(String massege) {
		super();
		this.massege = massege;
		this.timeStamp = LocalDateTime.now();
	}
	
	

}
