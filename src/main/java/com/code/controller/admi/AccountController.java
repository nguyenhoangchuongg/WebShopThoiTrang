package com.code.controller.admi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.code.dao.AccountDAO;
import com.code.entity.Account;

import jakarta.validation.Valid;




@Controller
public class AccountController {
	@Autowired
	AccountDAO dao;
	
	@RequestMapping("/admin/account")
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
	    Page<Account> page = dao.findAll(pageable);
	    model.addAttribute("page", page);
		return "tables";
	}

	@RequestMapping("/admin/accountedit")
	public String control(Model model) {
		Account account = new Account();
		model.addAttribute("item", account);
		return "accountedit";
	}
	@RequestMapping("/admin/account/edit/{username}")
	public String edit(Model model, @PathVariable("username") String username) {
		Account item = dao.findById(username).get();
		model.addAttribute("item", item);
		List<Account> items = dao.findAll();
		model.addAttribute("items", items);
		return "accountedit";
	}
	
	@RequestMapping("/admin/account/create")
//	public String create(Account item) {
//		dao.save(item);
//		return "redirect:/admin/accountedit";
//	}
	public String validatesave(ModelMap model,@Valid @ModelAttribute("item") Account item, BindingResult errors) {
		if(errors.hasErrors()) {
			model.addAttribute("message", "");
        }
        else{
                model.addAttribute("message", "");
                dao.save(item);
        }
		return "redirect:/admin/accountedit";
		
	}
	
	@RequestMapping("/admin/account/delete/{username}")
	public String create(@PathVariable("username") String username) {
		dao.deleteById(username);
		return "redirect:/admin/account";
	}
	
	@RequestMapping("/admin/account/update")
	public String update(Account item) {
		dao.save(item);
		return "redirect:/admin/account/edit/" + item.getUsername();
	}
	@ModelAttribute("active")
	public Map<Boolean, String>getActive(){
		Map<Boolean, String> map = new HashMap<>();
		map.put(true, "Active");
		map.put(false, "Unactive");
		return map;
	}
	
	@ModelAttribute("admin")
	public Map<Boolean, String>getAdmin(){
		Map<Boolean, String> map = new HashMap<>();
		map.put(true, "Admin");
		map.put(false, "Customer");
		return map;
	}
}
