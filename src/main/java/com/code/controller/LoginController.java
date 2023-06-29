package com.code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.code.contant.SessionAtribute;
import com.code.dao.AccountDAO;
import com.code.dao.ProductDAO;
import com.code.entity.Account;
import com.code.service.AccountService;
import com.code.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;







@Controller
public class LoginController {
	
	@Autowired
	AccountDAO accdao;

	@Autowired
	ProductDAO prdao;

//	@Autowired
//	CategoryDAO cadao;

	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpServletResponse response;

	@Autowired
	AccountService daoacc;
	
	@Autowired
	ProductService daopr;

	@Autowired
	HttpSession session;
	
	
	@RequestMapping("/resignter")
	public String index() {
		Account acc = new Account();
		String user = request.getParameter("createuser");
		String name = request.getParameter("createname");
		String email = request.getParameter("createemail");
		String pass = request.getParameter("createpass");	
		List<Account> list = daoacc.findAll();
		for (Account account : list) {
			if(account.getUsername().equalsIgnoreCase(user)) {
				System.out.println("trung username");
			}else {
				acc.setUsername(user);
				acc.setFullname(name);
				acc.setEmail(email);
				acc.setPassword(pass);
				acc.setAdmin(false);
				acc.setActive(true);
					
			}
		}
		if(acc.getFullname().isEmpty() || acc.getEmail().isEmpty() || acc.getPassword().isEmpty()) {
			System.out.println("k inser dc");
		}else {
			System.out.println("them thanh cong");
			accdao.save(acc);
		}
		
		return "/login";
	}
	
	@RequestMapping("/login")
	public String login() {
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		String sessionname ;
		String sessionpass ;

//		String sessionpass = (String) session.getAttribute(pass);
		List<Account> list = daoacc.findAll();
		for (Account account : list) {
			if (account.getUsername().equalsIgnoreCase(user) && account.getPassword().equals(pass)) {
				session.setAttribute(SessionAtribute.CURRENT_USER, account.getUsername());
				// cho admin
				if (account.getAdmin() == true) {	
					
					return "redirect:/admin/index";
				} else {
					// cho user
					
					System.err.println(account.getUsername() + account.getPassword() + account.getFullname());
					
					return "redirect:/index";
				}
				
//				Cookie c1 = createCookie("namecookie", account.getFullname());
//				resp.addCookie(c1);
//				Cookie[] ck = req.getCookies();
//				String value = "";
//				if (ck != null) {
//					for (Cookie cookie : ck) {
//						if (cookie.getName().equals("namecookie")) {
//							value = cookie.getValue();
//							value = value.replaceAll("%20", " ");
//							req.setAttribute("sa", value + " qua dep trai");
//							System.out.println(value + "nam dep trai");
//							break;
//						}
//					}
//					if (value == null) {
//						Cookie cookie1 = createCookie("sa", "chua co cookie");
//						resp.addCookie(cookie1);
//					}
//					
//				}
	
//			}
//
//		}
		
//		Account acc = daoacc.findUsernamePasswordAdmin(user, pass);
//		System.out.println(acc);
//		if(acc != null) {
//			session.setAttribute(SessionAtribute.CURRENT_USER, acc);
//			if(acc.getAdmin() == true) {
//				return "redirect:/test/index";
//			}else {
//				return "redirect:/index";
//			}
//			
//		}
			}
		}
		return "login";

	}
	
	@RequestMapping("/logout")
	public String logout() {
		session.removeAttribute(SessionAtribute.CURRENT_USER);
		return "index";
	}
}
