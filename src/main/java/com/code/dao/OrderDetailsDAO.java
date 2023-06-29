package com.code.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.entity.OrderDetail;



public interface OrderDetailsDAO extends JpaRepository<OrderDetail, Long> {
//	@Query("SELECT d.id, d.orderId, d.productId, d.quantity,d.price FROM  OrderDetail d"
//			+ "JOIN Order o on d.orderId = o.id"
//			+ "JOIN Product p on p.id = d.productId"
//			+ "WHERE o.username like ?1")
//	List<OrderDetail> history(String account);
}
