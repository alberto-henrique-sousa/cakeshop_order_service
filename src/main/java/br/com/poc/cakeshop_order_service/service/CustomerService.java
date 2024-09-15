package br.com.poc.cakeshop_order_service.service;

import br.com.poc.cakeshop_order_service.converter.CustomerConverter;
import br.com.poc.cakeshop_order_service.domain.entity.Customer;
import br.com.poc.cakeshop_order_service.model.CustomerDTO;
import br.com.poc.cakeshop_order_service.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerConverter customerConverter;

    public List<CustomerDTO> findAll() {
        final List<Customer> customers = customerRepository.findAll(Sort.by("id"));
        return customers.stream()
                .map(customerConverter::toDTO)
                .toList();
    }

    public Optional<CustomerDTO> get(Long id) {
        return customerRepository.findById(id).map(customerConverter::toDTO);
    }

    public CustomerDTO create(CustomerDTO customerDTO) {
        Customer customer = customerConverter.toEntity(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return customerConverter.toDTO(savedCustomer);
    }

    public Optional<CustomerDTO> update(Long id, CustomerDTO customerDTO) {
        return customerRepository.findById(id).map(existingCustomer -> {
            customerConverter.toEntity(customerDTO, existingCustomer);
            return customerConverter.toDTO(customerRepository.save(existingCustomer));
        });
    }

    public boolean delete(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
