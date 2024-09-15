package br.com.poc.cakeshop_order_service.model;

import br.com.poc.cakeshop_order_service.domain.enums.OrderTypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Builder
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Long id;

    private String externalId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal total;

    @NotNull
    private OrderTypeEnum status;

    private CustomerDTO customer;

    private List<OrderItemDTO> items;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private OffsetDateTime createAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private OffsetDateTime updateAt;

}
