package com.code.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.ToString;

@NamedQuery(
	name = "findById",
	query = "select p from Product p where p.id = ?1"
		)
@SuppressWarnings("serial")
@Data

@Entity 
@Table(name = "product")
public class Product  implements Serializable{
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Column(name="name")
	String name;
	
	@Column(name="image")
	String image;
	
	@Column(name="price")
	Double price;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "Createdate")
	Date createdate = new Date();
	
	@Column(name="avaliable")
	Boolean avaliable;
	
	@Column(name="quantity")
	Integer quantity;
	
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name = "categoryid")
	Category category;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	List<OrderDetail> orderDetails;	
}
