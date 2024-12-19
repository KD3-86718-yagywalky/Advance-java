package com.uop.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uop.dao.OrderDao;
import com.uop.dao.ProductDao;
import com.uop.dao.UserDao;
import com.uop.dto.OrderResqDTO;
import com.uop.dto.OrderPlaceDTO;
import com.uop.dto.OrderRespDTO;
import com.uop.pojos.Order;
import com.uop.pojos.Product;
import com.uop.pojos.User;
import com.uop.pojos.UserRole;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private ModelMapper model;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private UserDao userDao;

	@Override
	public String addOrder(Long userId, OrderPlaceDTO orderPlaceDTO) {

		User user = userDao.findById(userId).orElseThrow();
		
		Product p = productDao.findById(orderPlaceDTO.getProdId()).orElseThrow();
		
		if(user.getRole().equals(UserRole.CUSTOMER)) {
			if((p.getQuantity()- orderPlaceDTO.getQty())>=0) {
			Order order = new Order(p.getPrice(), orderPlaceDTO.getQty(), user, p);
			
			orderDao.save(order);
			p.setQuantity(p.getQuantity()-orderPlaceDTO.getQty());
			return "Saved Completely";
			}
			return "Quantity is not available";
		}
		return "Not a valid user";
	
	}

	@Override
	public List<OrderRespDTO> getAll() {
		
		return orderDao.findAll().stream().map(list -> model.map(list, OrderRespDTO.class)).collect(Collectors.toList());
	}

	@Override
	public List<OrderRespDTO> getById(Long id) {
		
		User user = userDao.findById(id).orElseThrow();
		System.out.println(user);
		return orderDao.findByUserId(user).stream().map(list -> model.map(list, OrderRespDTO.class)).collect(Collectors.toList());
	}

}
