package com.uop.dto;


import com.uop.pojos.Product;
import com.uop.pojos.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class OrderRespDTO extends BaseEntityDTO{
	
	private double totalAmount;

	private int qty;
	
	private User userId;
	
	private Product productid;

}
