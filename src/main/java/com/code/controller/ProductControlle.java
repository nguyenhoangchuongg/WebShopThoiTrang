package com.code.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.code.dao.ProductDAO;
import com.code.entity.Product;
import com.code.service.SessionService;



@Controller
public class ProductControlle {
	@Autowired
	ProductDAO dao;
	
	@Autowired
	SessionService session;
	
	@RequestMapping("/product/SearchAndPage")
	public String searchAndPage(Model model, @RequestParam("keywords") Optional<String> kw,
			@RequestParam("price") Optional<Double> price,
			@RequestParam("category") Optional<String> category,
			@RequestParam("p") Optional<Integer> p) {
		String kwords = kw.isPresent() ? kw.get() : session.get("keywords","");
		session.set("keywords", kwords);
		String cte = category.isPresent() ? category.get() : session.get("category","");
//		String cte = category.orElse(session.get("category",""));
		session.set("category", cte);
		String priceStr = session.get("price", "");
		Double pri = priceStr.isEmpty() ? null : Double.valueOf(priceStr);
//		Double pri = price.isPresent() ? price.get() : Double.valueOf(session.get("price", ""));
//		Double pri = price.orElse(Double.valueOf(session.get("price", "")));
		session.set("price", priceStr);
		int number_ofCategory_page = 5;
		Pageable pageable = PageRequest.of(p.orElse(0), number_ofCategory_page);
		Page<Product> page = dao.findByNameAndPriceAndCategoryId(kwords,price,cte,pageable);
		model.addAttribute("page",page);
		return "search";
	}
}
