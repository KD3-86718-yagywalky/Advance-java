package com.uop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductRespDTO extends BaseEntityDTO{
	
	private String productName;

	private double price;

	private String desc;
	
	private boolean status;

	private int quantity;

}
