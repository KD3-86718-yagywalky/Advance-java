package com.uop.service;

import java.util.List;

import com.uop.dto.ProductReqDTO;
import com.uop.dto.ProductRespDTO;
import com.uop.pojos.Product;

public interface ProductService {
	
	String addProduct(ProductReqDTO prod, Long userId);
	
	List<ProductRespDTO> getAllProduct();
	
	String deleteProduct(Long id, Long userId);

}
