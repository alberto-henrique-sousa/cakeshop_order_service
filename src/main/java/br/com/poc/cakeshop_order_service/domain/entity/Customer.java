package br.com.poc.cakeshop_order_service.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "CUSTOMER")
public class Customer extends Base implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    @NotBlank
    @Length(min = 5)
    @Column(name = "NAME")
    private String name;

    @Email
    @NotBlank
    @Column(name = "EMAIL", unique = true)
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

}
