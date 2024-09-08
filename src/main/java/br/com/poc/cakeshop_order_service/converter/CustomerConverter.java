package br.com.poc.cakeshop_order_service.converter;

import br.com.poc.cakeshop_order_service.domain.entity.Customer;
import br.com.poc.cakeshop_order_service.model.CustomerDTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {

    public CustomerDTO toDTO(Customer customer) {

        return CustomerDTO.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .createAt(customer.getCreateAt())
                .updateAt(customer.getUpdateAt())
                .build();
    }

    public Customer toEntity(CustomerDTO customerDTO) {

        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        return customer;
    }
}
