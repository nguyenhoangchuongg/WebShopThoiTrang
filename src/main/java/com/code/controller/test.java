package com.code.controller;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.code.dao.AccountDAO;
import com.code.dao.ProductDAO;
import com.code.entity.Product;
import com.code.service.AccountService;
import com.code.service.ProductService;
import com.code.service.SessionService;
import com.code.service.ShopCart;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class test {

	@Autowired
	AccountDAO accdao;

	@Autowired
	ProductDAO prdao;
	
//	@Autowired
//	CategoryDAO catedao;

	@Autowired
	HttpServletRequest req;

	@Autowired
	HttpServletResponse resp;

	@Autowired
	AccountService daoacc;
	
	@Autowired
	ProductService daopr;
	
	@Autowired
	ShopCart shop;

	@Autowired
	HttpSession session;
	
	@Autowired
	SessionService sessionservice;

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	
	@RequestMapping("/index/shop-page")
	public String page(Model model, @RequestParam("p") Optional<Integer> p) {
		Pageable  page = PageRequest.of(p.orElse(0), 6);
		Page<Product> pages = prdao.findAllPage(page);
//		List<CountCate> listcate = catedao.findCount();
		model.addAttribute("allpr", shop.getCount());
//		model.addAttribute("categories", listcate);
		model.addAttribute("page", pages);
		return "shop";
	}
	
	@RequestMapping("/index/search-name")
	public String findByName(Model model, @RequestParam("keyword") Optional<String> kw, @RequestParam("p") Optional<Integer> p) {
		String kwords = kw.orElse(sessionservice.get("keyword",""));
		sessionservice.set("keyword", kwords);
		Pageable page = PageRequest.of(p.orElse(0),5);
		Page<Product> pages = prdao.findByName("%"+kwords+"%", page);
		model.addAttribute("page", pages);
		return "shop";
	}
	
	
	@GetMapping("/index/shop/detail/{id}")
	public String index3(@PathVariable("id") Integer id) {
		Product pr = daopr.findById(id);
		req.setAttribute("listDetails", pr);
		return "shop-detail";
	}

	@RequestMapping("/index/addcart/{id}")
	public String addCart(@PathVariable("id") Integer id) {
		shop.add(id);
		return "redirect:/index/cart";
	}
	
	@RequestMapping("/index/delete/{id}")
	public String deleteCart(@PathVariable("id") Integer id) {
		shop.remove(id);
		return "redirect:/index/cart";
		
	}
	
	
	@GetMapping("/index/cart")
	public String index4() {
		req.setAttribute("addcart", shop.getItems());
		req.setAttribute("total", shop.getTotal());
		return "shop-cart";
	}
	


	private Cookie createCookie(String cookieName, String cookieValue) {
		try {
			cookieValue = java.net.URLEncoder.encode(cookieValue, "utf-8").replaceAll("\\+", "%20");
		} catch (Exception e) {

		}
		Cookie cookie = new Cookie(cookieName, cookieValue);
		cookie.setPath("/");
		cookie.setMaxAge(120);
		cookie.setHttpOnly(true);
		cookie.setSecure(true);
		return cookie;
	}

	
	@RequestMapping("/cart/update/{id}")
	public String updatecart(@PathVariable("id") Integer id, @RequestParam("quantity") Integer quantity) {
		shop.update(id, quantity);
//		System.out.println(s + "haha");
		return "redirect:/index/cart";
	}
	
	@RequestMapping("/cart/clear")
	public String clearCart() {
		shop.clear();
		return "redirect:/index/cart";
	}
}
