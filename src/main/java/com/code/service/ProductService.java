package com.code.service;

import java.util.Collection;
import java.util.List;

import com.code.entity.CartItem;
import com.code.entity.Product;




public interface ProductService {
	List<Product> findAll();

	List<Product> finId(Integer id);

	Product findById(Integer id);

	void addCart(Product pr);

	Product findByName(String name);

	Collection<Product> getDetails();
	
	Collection<CartItem> getDetail();

	void deleteCart(Integer id);
	
	double total();
	
	Product updatecart(Integer id,int part);
	
	void clear();
	
	int countpr();
	
	Product getIdPr(Collection<Product> co);
}
