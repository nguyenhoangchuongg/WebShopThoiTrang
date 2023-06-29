package com.code.entity;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class HistoryOrderDetails implements Serializable {
	@Id
	private Product product;
	private OrderDetail orderDetail;
	private Order order;
}
