package com.code.serviceImple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.dao.OrderDAO;
import com.code.entity.Order;
import com.code.service.OrderService;



@Service
public class OrderServiceImple implements OrderService {
	@Autowired
	OrderDAO dao;
	
	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Order findByname(String phone) {
		// TODO Auto-generated method stub
		for (Order i: dao.findAll()) {
			if(i == null) {
				
				System.out.println("k co order");
			}else {
				if(i.getPhone().equals(phone)) {
					System.out.println(i + "la no");
					return i;
				}
			}
		}
		return null;
	}

	@Override
	public Order getIdOrder() {
	// TODO Auto-generated method stub
		List<Order> list = dao.findAll();
		Order last = list.get(list.size() -1);
		Order o = new Order();
		o.setId(last.getId());
		return o;
	}
	
	

}
