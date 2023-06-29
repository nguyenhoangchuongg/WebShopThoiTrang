package com.code.dao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.code.entity.Product;
import com.code.entity.ReportCategory;



public interface ProductDAO extends JpaRepository<Product, Integer> {

	List<Product> findAll();
	@Query("SELECT o FROM Product o WHERE o.name like %?1%")
	List<Product> findByName(String name);
	
	
	@Query("SELECT o FROM Product o WHERE o.price BETWEEN ?1 AND ?2")
	Page<Product> findByPrice(Integer minPrice, Integer maxPrice, Pageable pageable);
	

	Page<Product> findAllByNameLike(String keywords, Pageable pageable);
	
	@Query("SELECT o FROM Product o WHERE o.name LIKE ?1")
	Page<Product> findByKeywords(String keywords, Pageable pageable);
	
	
	@Query("SELECT o FROM Product o WHERE o.category.id = ?1")
	Page<Product> findByCategory(String id, Pageable pageable);

	
	@Query("SELECT count(p.id) FROM Product p")
	int findAllProduct();
	
	@Query("SELECT o FROM Product o WHERE o.category.id = ?1")
	List<Product> findByCategoryHome(String id);
	
	@Query("SELECT new ReportCategory(o.category, sum(o.price), count(o)) "
			+ " FROM Product o "
			+ " GROUP BY o.category"
			+ " ORDER BY sum(o.price) DESC")
	List<ReportCategory> getReportCategory();
	Page<Product> findByNameAndPriceAndCategoryId(String keyword, Optional<Double> price, String category,
			Pageable pageable);
	
	@Query("SELECT p from Product p WHERE p.name LIKE ?1")
	Page<Product> findByName(String keywords, Pageable pageble);
	@Query("SELECT p from Product p")
	Page<Product> findAllPage(Pageable pageable);
}
