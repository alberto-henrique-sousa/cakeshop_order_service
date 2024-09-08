package br.com.poc.cakeshop_order_service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class CakeShopOrderServiceApplication {

	@Value("${spring.jackson.time-zone}")
	private String timeZone;

	@PostConstruct
	public void init(){
		TimeZone.setDefault(TimeZone.getTimeZone(timeZone));
	}

	public static void main(String[] args) {
		SpringApplication.run(CakeShopOrderServiceApplication.class, args);
	}

}
