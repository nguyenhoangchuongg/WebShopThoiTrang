package com.code.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;
@Data
@Entity
@Table(name = "orderdetails")
public class OrderDetail implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	Double price;
	Integer quantity;
	
	@ToString.Exclude
	@ManyToOne @JoinColumn(name = "productid")
	Product product;
	
	@ToString.Exclude
	@ManyToOne @JoinColumn(name = "orderid")
	Order order;
}
