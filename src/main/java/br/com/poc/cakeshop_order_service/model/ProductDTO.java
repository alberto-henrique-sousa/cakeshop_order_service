package br.com.poc.cakeshop_order_service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Builder
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;

    @NotBlank
    @Length(min = 5)
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Positive
    private BigDecimal price;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private OffsetDateTime createAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private OffsetDateTime updateAt;

}
