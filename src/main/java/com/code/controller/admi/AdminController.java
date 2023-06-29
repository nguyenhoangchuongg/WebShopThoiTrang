package com.code.controller.admi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.code.dao.AccountDAO;
import com.code.dao.ProductDAO;

@Controller
public class AdminController {
	@RequestMapping("/admin/index")
	public String index() {
		return "indexadmin";
	}
	@RequestMapping("/admin/stats")
	public String indexx() {
		return "indexthongke";
	}
	
}
