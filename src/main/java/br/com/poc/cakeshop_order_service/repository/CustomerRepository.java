package br.com.poc.cakeshop_order_service.repository;

import br.com.poc.cakeshop_order_service.domain.entity.Customer;
import io.micrometer.common.lang.NonNullApi;
import io.micrometer.common.lang.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@NonNullApi
public interface CustomerRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

    List<Customer> findAll(@Nullable Specification<Customer> spec);

    Page<Customer> findAll(@Nullable Specification<Customer> spec, Pageable pageable);

}
