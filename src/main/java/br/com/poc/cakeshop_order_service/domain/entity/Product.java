package br.com.poc.cakeshop_order_service.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "PRODUCT")
public class Product extends Base implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    @NotBlank
    @Length(min = 5)
    @Column(name = "NAME", unique = true)
    private String name;

    @Column(name = "PRICE")
    @Positive
    private BigDecimal price = BigDecimal.ZERO;

}
