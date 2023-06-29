package com.code.controller.admi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.lang.model.element.Element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.code.dao.CategoryDAO;
import com.code.dao.ProductDAO;
import com.code.entity.Category;
import com.code.entity.Product;




@Controller
public class ProductController {
	@Autowired
	ProductDAO dao;
	@Autowired
	CategoryDAO categoryDAO;

	@RequestMapping("/admin/product")
	public String paginate(Model model,	@RequestParam("p") Optional<Integer> p) {

	    int pageSize = 5;
	    int pageNumber = p.orElse(0); //giá trị của Optional<Integer> p được lấy ra và gán cho biến pageNumber (Trang hiện tại)
	    long totalProducts = dao.count(); // lấy tổng số lượng sản phẩm từ cơ sở dữ liệu	    
//	    tính toán số trang tối đa có thể có bằng cách lấy 
//	    bằng tổng số lượng sản phẩm chia cho số lượng sản phẩm trong mỗi trang, 
//	    sau đó ép kiểu về kiểu số nguyên và lấy phần nguyên của kết quả
	    int totalPages = (int) Math.ceil((double) totalProducts / pageSize);
//	    Math.ceil() làm tròn một số thực thành số nguyên lớn nhất mà không nhỏ hơn số thực ban đầu
	    if (pageNumber >= totalPages) {
	        pageNumber = 0;
	    }
	    if(pageNumber < 0) {
	    	pageNumber = totalPages - 1;
	    }
	    
	    int startPage = Math.max(0, pageNumber - 1); // Trang bắt đầu không nhỏ hơn 0
	    int endPage = Math.min(totalPages - 1, pageNumber + 1); // Trang cuối không lớn hơn tổng số trang (totalPages)
	    List<Integer> pageNumbers = new ArrayList<>(); // pageNumbers danh sách số trang
    	for (int i = startPage; i <= endPage; i++) { // lặp qua các số trang trong phạm vi từ startPage đến endPage
    		pageNumbers.add(i);// Math.max/min so sánh 2 số
	    }
	    model.addAttribute("pageNumbers", pageNumbers);
	    model.addAttribute("currentPage", pageNumber);
	    model.addAttribute("totalPages", totalPages);
	    Pageable pageable = PageRequest.of(pageNumber, pageSize);
	    Page<Product> page = dao.findAll(pageable);
	    model.addAttribute("page", page);
		return "product";
	}

	@RequestMapping("/admin/productedit")
	public String control(Model model) {
		Product account = new Product();
		model.addAttribute("item", account);
		return "productedit";
	}
	@RequestMapping("/admin/product/edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer username) {
		Product item = dao.findById(username).get();
		model.addAttribute("item", item);
		List<Product> items = dao.findAll();
		model.addAttribute("items", items);
		return "productedit";
	}
	
	@RequestMapping("/admin/product/create")
	public String create(Product item) {
		dao.save(item);
		return "redirect:/admin/productedit";
	}
	
	@RequestMapping("/admin/product/delete/{id}")
	public String create(@PathVariable("id") Integer username) {
		dao.deleteById(username);
		return "redirect:/admin/product";
	}
	
	@RequestMapping("/admin/product/update")
	public String update(Product item) {
		dao.save(item);
		return "redirect:/admin/product/edit/" + item.getId();
	}
	@ModelAttribute("avaliable")
	public Map<Boolean, String>getAvaliable(){
		Map<Boolean, String> map = new HashMap<>();
		map.put(true, "Active");
		map.put(false, "Unactive");
		return map;
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		List<Category> categories = categoryDAO.findAll();
		return categories;
	}
	

}
