package com.code.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.entity.Category;

public interface CategoryDAO extends JpaRepository<Category, String> {
	
}
