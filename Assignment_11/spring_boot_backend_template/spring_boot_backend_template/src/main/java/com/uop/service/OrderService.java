package com.uop.service;

import java.util.List;

import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;

import com.uop.dto.OrderResqDTO;
import com.uop.dto.OrderPlaceDTO;
import com.uop.dto.OrderRespDTO;

public interface OrderService {

		String addOrder(Long userId, OrderPlaceDTO orderPlaceDTO);

		List<OrderRespDTO> getAll();

		List<OrderRespDTO> getById(Long id);
}
