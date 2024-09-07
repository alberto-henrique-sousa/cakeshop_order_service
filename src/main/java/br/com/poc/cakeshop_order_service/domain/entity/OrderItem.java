package br.com.poc.cakeshop_order_service.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "ORDER_ITEM")
public class OrderItem implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID", nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product product;

    @Column(name = "PRICE")
    @Positive
    private BigDecimal price = BigDecimal.ZERO;

    @Column(name = "QUANTITY")
    @Positive
    private Integer quantity = 1;

    @CreationTimestamp
    @Setter(AccessLevel.NONE)
    @Column(name = "CREATE_AT")
    private OffsetDateTime createAt = OffsetDateTime.now();

    @UpdateTimestamp
    @Setter(AccessLevel.NONE)
    @Column(name = "UPDATE_AT")
    private OffsetDateTime updateAt = OffsetDateTime.now();

}
