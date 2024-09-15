package br.com.poc.cakeshop_order_service.domain.entity;

import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;

@Getter
@Setter
public class Base {

    @CreationTimestamp
    @Setter(AccessLevel.NONE)
    @Column(name = "CREATE_AT")
    private OffsetDateTime createAt = OffsetDateTime.now();

    @UpdateTimestamp
    @Setter(AccessLevel.NONE)
    @Column(name = "UPDATE_AT")
    private OffsetDateTime updateAt = OffsetDateTime.now();

}
