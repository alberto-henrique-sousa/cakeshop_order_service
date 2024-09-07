package br.com.poc.cakeshop_order_service.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "CUSTOMER")
public class Customer {

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

    @CreationTimestamp
    @Setter(AccessLevel.NONE)
    @Column(name = "CREATE_AT")
    private OffsetDateTime createAt = OffsetDateTime.now();

    @UpdateTimestamp
    @Setter(AccessLevel.NONE)
    @Column(name = "UPDATE_AT")
    private OffsetDateTime updateAt = OffsetDateTime.now();

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

}
