package com.code.service;

import java.util.Collection;

import com.code.entity.CartItem;



public interface ShopCart {
	CartItem add(Integer id);

	CartItem sub(Integer id);

	void remove(Integer id);

	CartItem update(Integer id, int qty);

	void clear();

	Collection<CartItem> getItems();

	int getCount();

	double getAmount();

	double getTotal();
}
