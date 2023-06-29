package com.code.serviceImple;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.dao.ProductDAO;
import com.code.entity.CartItem;
import com.code.entity.Product;
import com.code.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;



@Service
public class ProductServiceImple implements ProductService {
	@Autowired
	ProductDAO dao;
	@Autowired
	HttpServletRequest request;
	
	Map<Integer, Product> map = new HashMap<>();
	Map<Integer, CartItem> maps = new HashMap<>();
//	public static Map<Integer, Product> map = new HashMap<>();
//	static {
//		map.put(null, null);
//	}
	
	
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Product findByName(String name) {
		// TODO Auto-generated method stub
		Product pr = new Product();
		for (Product i : dao.findAll()) {
			System.out.println(i.getName());
		}
		return null;
	}

	@Override
	public List<Product> finId(Integer id) {
		List<Product> list = new ArrayList<>();
		for (Product pr : dao.findAll()) {
			if(pr.getId() == id) {
				System.out.println("oke");
				list.add(pr);
			}
		}
		return list;
	}

	@Override
	public Product findById(Integer id) {
		for (Product pr : dao.findAll()) {
			if(pr.getId() == id) {
				System.out.println("oke");
				return pr;	
			}
		}
		return null;
	}

	@Override
	public void addCart(Product pr) {
		// TODO Auto-generated method stub
		Product pr1 = map.get(pr.getId());
		if(pr1 == null) {
			map.put(pr.getId(), pr);
		}else {
			pr1.setQuantity(pr1.getQuantity()+ 1);
		}
	}

	@Override
	public Collection<Product> getDetails() {
		// TODO Auto-generated method stub
		return map.values();
	}

	@Override
	public void deleteCart(Integer id) {
		map.remove(id);
		
	}

	@Override
	public double total() {
		// TODO Auto-generated method stub
		double tong = 0;
		for (Product pr : map.values()) {
			tong += pr.getQuantity() * pr.getPrice();
		}
		return tong;
	}

	@Override
	public Product updatecart(Integer id, int part) {
		// TODO Auto-generated method stub
		for (Product i : map.values()) {
			if(i.getId() == id) {
				i.setQuantity(part);
				return i;
			}
		}
		
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		map.clear();
	}

	@Override
	public int countpr() {
		// TODO Auto-generated method stub
		Integer i = dao.findAllProduct();	
		return i;
	}

	@Override
	public Product getIdPr(Collection<Product> co) {
		Product p = new Product();
		Iterator<Product> in = co.iterator();
		while(in.hasNext()) {
			Product pp = in.next();
			return pp;
		}
		return null;
	}

	@Override
	public Collection<CartItem> getDetail() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Product getIdOrder() {	
//		Product p = new Product();
//		for (Product i : getDetails()) {
//			p.setId(i.getId());
//			return p;
//		}
//		return null;
//	}
	
	

	
	
}
