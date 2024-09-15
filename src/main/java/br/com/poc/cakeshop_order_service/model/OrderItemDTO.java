package br.com.poc.cakeshop_order_service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Builder
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {

    private Long id;

    private ProductDTO product;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Positive
    private BigDecimal price;

    @Positive
    private Integer quantity;

    private Long orderId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private OffsetDateTime createAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private OffsetDateTime updateAt;

}
