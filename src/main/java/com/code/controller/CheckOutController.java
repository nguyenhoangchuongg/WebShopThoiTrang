package com.code.controller;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.code.contant.SessionAtribute;
import com.code.dao.AccountDAO;
import com.code.dao.OrderDAO;
import com.code.dao.OrderDetailsDAO;
import com.code.entity.Account;
import com.code.entity.CartItem;
import com.code.entity.Order;
import com.code.entity.OrderDetail;
import com.code.entity.Product;
import com.code.service.OrderService;
import com.code.service.ProductService;
import com.code.service.ShopCart;

import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class CheckOutController {

	@Autowired
	OrderDAO ordao;

	@Autowired
	AccountDAO accdao;

	@Autowired
	HttpServletRequest req;

	@Autowired
	HttpServletResponse resp;

	@Autowired
	OrderService daoor;

	@Autowired
	ProductService daopr;

	@Autowired
	HttpSession session;

	@Autowired
	JavaMailSender sender;

	@Autowired
	ProductService prservice;

	@Autowired
	OrderService orservice;
	
	@Autowired
	OrderDetailsDAO detailsdao;
	
	@Autowired
	ShopCart shop;

	@RequestMapping("/index/checkout")
	public String index() {

		req.setAttribute("cartotal", shop.getItems());
		req.setAttribute("totalfinish", shop.getTotal());

		return "checkout";
	}

	@RequestMapping(value = "/index/checkout/bill", method = RequestMethod.POST)
	public String billOrder(Model model, @RequestParam("emailbill") String mail,
			@RequestParam("namebill") String firstName, @RequestParam("lastnamebill") String lastName,
			@RequestParam("addressbill") String address, @RequestParam("phonebill") String phone,
			@RequestParam("notebill") String note) {
		try {
			if (session.getAttribute(SessionAtribute.CURRENT_USER) == null) {
				return "redirect:/login";
			} else {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String formattedDate = formatter.format(new Date());
				Date date = formatter.parse(formattedDate);
				System.out.println(formattedDate);
				String chuoi = "";
				String tong = "Total finish: " + daopr.total();
				System.out.println(tong);
				Collection<Product> collec = daopr.getDetails();

				// day xuong order
				String insertusername = (String) session.getAttribute(SessionAtribute.CURRENT_USER);
				Account a = accdao.findByUsername(insertusername);
				System.out.println("acc" + a.getFullname());
				
				
				Order oder = new Order();
				oder.setAccount(a);
				oder.setAddress(address);
				oder.setPhone(phone);
				oder.setCreateDate(date);
				ordao.save(oder);

				System.out.println("hello nam");
				for (CartItem p : shop.getItems() ) {
					OrderDetail ord = new OrderDetail();
					ord.setOrder(oder);
					ord.setPrice(shop.getTotal());
					ord.setQuantity(p.getQty());
					
					Product pr = new Product();
					pr.setId(p.getId());
					pr.setName(p.getName());
					ord.setProduct(pr);
					detailsdao.save(ord);
					System.out.println("ket qua : " + ord.getPrice() );
				}
				
				
				

				

				// gui mail
				MimeMessage getmail = sender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(getmail);
				helper.setFrom("namntps23848@fpt.edu.vn", "namntps23848@fpt.edu.vn");
				helper.setTo(mail);
				helper.setSubject("Bill from Male Fashion");
				for (CartItem pro : shop.getItems()) {
					chuoi += "Name product:" + pro.getName() + " ---Total:"
							+ (pro.getQty() * pro.getPrice()) + "\n";
				}
				System.out.println(chuoi);
				helper.setText(chuoi + "\n" + tong, true);
				sender.send(getmail);
				System.out.println("gui thanh cong");

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("khong thanh cong");
		}
		return "checkout";
	}

}
