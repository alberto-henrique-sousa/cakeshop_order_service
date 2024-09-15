package br.com.poc.cakeshop_order_service.domain.entity;

import br.com.poc.cakeshop_order_service.domain.enums.OrderTypeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "ORDER")
public class Order extends Base implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    @Column(name = "EXTERNAL_ID", unique = true)
    private String externalId = UUID.randomUUID().toString();

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    private Customer customer;

    @Column(name = "TOTAL")
    private BigDecimal total = BigDecimal.ZERO;

    @Column(name = "STATUS")
    @NotNull
    private OrderTypeEnum status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items;

}
