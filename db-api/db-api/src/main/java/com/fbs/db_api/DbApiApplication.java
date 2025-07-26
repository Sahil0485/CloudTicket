package com.fbs.db_api;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DbApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbApiApplication.class, args);
		System.out.println("DB api running");
	}

}
