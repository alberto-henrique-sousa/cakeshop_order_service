package br.com.poc.cakeshop_order_service;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class CakeshopOrderServiceApplication {

	@PostConstruct
	public void init(){
		// Definir o time zone padrão
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
	}

	public static void main(String[] args) {
		SpringApplication.run(CakeshopOrderServiceApplication.class, args);
	}

}
