package com.uop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class OrderPlaceDTO {
	
	private Long prodId;
	private int qty;
}
