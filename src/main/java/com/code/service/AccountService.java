package com.code.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;


import com.code.entity.Account;

public interface AccountService {

	Optional<Account> findById(String id);

	List<Account> findAll();

	Account findByName(String name);
	
	Account findAcc(String user);

	Account findUsernamePasswordAdmin(String name, String pass);

}
