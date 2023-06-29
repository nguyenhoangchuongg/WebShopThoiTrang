package com.code.serviceImple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.dao.AccountDAO;
import com.code.entity.Account;
import com.code.service.AccountService;





@Service
public class AccountServiceImple implements AccountService {

	@Autowired
	AccountDAO dao;

	@Override
	public List<Account> findAll() {
		return dao.findAll();
	}

	@Override
	public Account findByName(String name) {
		Account ac = new Account();
		List<Account> list = dao.findAll();
		for (Account account : list) {
			if(account.getFullname().equalsIgnoreCase(name)) {
				ac.setFullname(name);
			}
		}
		return ac;
		
	}

	@Override
	public Optional<Account> findById(String id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Account findAcc(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account findUsernamePasswordAdmin(String name, String pass) {
		// TODO Auto-generated method stub
		Account acc = new Account();
		List<Account> list = dao.findAll();
		for (Account account : list) {
			if(account.getUsername().equalsIgnoreCase(name) && account.getPassword().equalsIgnoreCase(pass)) {
				if(account.getAdmin() == true) {
					acc.setUsername(name);
					acc.setPassword(pass);
					acc.setAdmin(true);
				}else {
					acc.setUsername(name);
					acc.setPassword(pass);
					acc.setAdmin(false);
				}
			}
		}
		return acc;
	}

//	@Override
//	public Account findAcc(String user) {
//		
//			List<Account> list = dao.findAll();
//			
//			Account acc = new Account();
//			if(list!=null) {
//				for (Account account : list) {
//					if(account.getUsername().equals(user)) {
//						acc.setUsername(user);
//						
//					}
//				}
//			}
//		return acc;
//	}

	

	
	
	
	
	
}
