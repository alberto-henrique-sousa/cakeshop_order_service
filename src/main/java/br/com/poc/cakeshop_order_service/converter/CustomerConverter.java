package br.com.poc.cakeshop_order_service.converter;

import br.com.poc.cakeshop_order_service.domain.entity.Customer;
import br.com.poc.cakeshop_order_service.model.CustomerDTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {

    public CustomerDTO toDTO(@NotNull Customer customer) {

        return CustomerDTO.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .createAt(customer.getCreateAt())
                .updateAt(customer.getUpdateAt())
                .build();
    }

    public Customer toEntity(@NotNull CustomerDTO customerDTO) {

        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        setCustomer(customerDTO, customer);
        return customer;
    }

    public void toEntity(CustomerDTO customerDTO, Customer customer) {

        setCustomer(customerDTO, customer);
    }

    private static void setCustomer(@NotNull CustomerDTO customerDTO, @NotNull Customer customer) {
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
    }
}
