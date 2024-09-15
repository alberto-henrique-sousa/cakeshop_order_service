package br.com.poc.cakeshop_order_service.repository;

import br.com.poc.cakeshop_order_service.domain.entity.Order;
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
public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {

    List<Order> findAll(@Nullable Specification<Order> spec);

    Page<Order> findAll(@Nullable Specification<Order> spec, Pageable pageable);

}
