package br.com.poc.cakeshop_order_service.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("br.com.poc.cakeshop_order_service.domain.entity")
@EnableJpaRepositories("br.com.poc.cakeshop_order_service.repository")
@EnableTransactionManagement
public class DomainConfig {


}
