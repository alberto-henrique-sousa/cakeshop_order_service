package br.com.poc.cakeshop_order_service.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "ORDER")
public class Order implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    @Column(name = "EXTERNAL_ID")
    private String externalId = UUID.randomUUID().toString();

    @Column(name = "DATETIME")
    private OffsetDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    private Customer customer;

    @Column(name = "TOTAL")
    private BigDecimal total = BigDecimal.ZERO;

    @UpdateTimestamp
    @Setter(AccessLevel.NONE)
    @Column(name = "UPDATE_AT")
    private OffsetDateTime updateAt = OffsetDateTime.now();

    @CreationTimestamp
    @Setter(AccessLevel.NONE)
    @Column(name = "CREATE_AT")
    private OffsetDateTime createAt = OffsetDateTime.now();

}
