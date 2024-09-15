package br.com.poc.cakeshop_order_service.controller;

import br.com.poc.cakeshop_order_service.model.CustomerDTO;
import br.com.poc.cakeshop_order_service.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/customers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAll() {
        List<CustomerDTO> customers = customerService.findAll();
        if (customers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getById(
            @PathVariable final Long id) {
        Optional<CustomerDTO> customer = customerService.get(id);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> create(
            @RequestBody @Valid final CustomerDTO customerDTO) {
        CustomerDTO createdCustomer = customerService.create(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> update(
            @PathVariable final Long id,
            @RequestBody @Valid final CustomerDTO customerDTO) {
        Optional<CustomerDTO> updatedCustomer = customerService.update(id, customerDTO);
        return updatedCustomer.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {
        if (customerService.delete(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

