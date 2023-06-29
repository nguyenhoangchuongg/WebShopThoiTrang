package com.code.service;

import java.util.List;

import com.code.entity.Order;


public interface OrderService  {
	List<Order> findAll();
	
	Order findByname(String phone);
	
	Order getIdOrder();
}
