package com.code.entity;

import java.io.Serializable;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "account")
public class Account  implements Serializable{
	
	@Id
	
	@NotBlank 
	@Column(name="username")
	String username;
	
	@NotBlank 
	@Column(name="password")
	String password;
	
	@NotBlank 
	@Column(name="fullname")
	String fullname;
	
	@NotBlank
	@Email
	@Column(name="email")
	String email;
	
	@Column(name="photo")
	String photo;
	
	@NotNull 
	@Column(name="admin")
	Boolean admin;
	
	@NotNull 
	@Column(name="active")
	Boolean active;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Order> orders;
}
