package com.code.serviceImple;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.dao.ProductDAO;
import com.code.entity.CartItem;
import com.code.entity.Product;
import com.code.service.ShopCart;



@Service
public class ShopCartImple implements ShopCart {
	
	@Autowired
	ProductDAO dao;
	
	Map<Integer, CartItem> map = new HashMap<>();

	@Override
	public CartItem add(Integer id) {
		// TODO Auto-generated method stub
		CartItem item = map.get(id);
		if(item == null) {
			Product pr = dao.findById(id).get();
			item = new CartItem();
			item.setId(pr.getId());
			item.setImage(pr.getImage());
			item.setName(pr.getName());
			item.setPrice(pr.getPrice());
			item.setQty(getCount());
			map.put(id, item);
		}else {
			item.setQty(getCount());
		}
		return item;
	}

	@Override
	public CartItem sub(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		map.remove(id);
		
	}

	@Override
	public CartItem update(Integer id, int qty) {
		CartItem item = map.get(id);
		item.setQty(qty);
		return item;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		map.clear();
		
	}

	@Override
	public Collection<CartItem> getItems() {
		// TODO Auto-generated method stub
		return map.values();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		Integer i = dao.findAllProduct();
		return i;
	}

	@Override
	public double getAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTotal() {
		// TODO Auto-generated method stub
		
		return map.values().stream().mapToDouble(item -> item.getPrice()*item.getQty()).sum();
	}

}
