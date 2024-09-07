package br.com.poc.cakeshop_order_service.repository;

import br.com.poc.cakeshop_order_service.domain.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

    List<Customer> findAll(Specification<Customer> spec);

    Page<Customer> findAll(Specification<Customer> spec, Pageable pegeable);

}
