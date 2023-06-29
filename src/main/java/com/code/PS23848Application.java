package com.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.code.DAO")
@EntityScan(basePackages = "com.code.entity" )
public class PS23848Application {

	public static void main(String[] args) {
		SpringApplication.run(PS23848Application.class, args);
		System.out.println("da len");
	}

}
