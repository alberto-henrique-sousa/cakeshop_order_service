package br.com.poc.cakeshop_order_service.converter;

import br.com.poc.cakeshop_order_service.domain.entity.OrderItem;
import br.com.poc.cakeshop_order_service.model.OrderItemDTO;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderItemConverter {

    private final ProductConverter productConverter;

    public OrderItemDTO toDTO(@NotNull OrderItem orderItem) {

        return OrderItemDTO.builder()
                .id(orderItem.getId())
                .product(productConverter.toDTO(orderItem.getProduct()))
                .price(orderItem.getPrice())
                .quantity(orderItem.getQuantity())
                .createAt(orderItem.getCreateAt())
                .updateAt(orderItem.getUpdateAt())
                .build();
    }

    public OrderItem toEntity(@NotNull OrderItemDTO orderItemDTO) {

        OrderItem orderItem = new OrderItem();
        orderItem.setId(orderItemDTO.getId());
        setOrderItem(orderItemDTO, orderItem);
        return orderItem;
    }

    public void toEntity(OrderItemDTO orderItemDTO, OrderItem orderItem) {

        setOrderItem(orderItemDTO, orderItem);
    }

    private static void setOrderItem(@NotNull OrderItemDTO orderItemDTO, @NotNull OrderItem orderItem) {
        orderItem.setProduct(orderItem.getProduct());
        orderItem.setQuantity(orderItemDTO.getQuantity());
        orderItem.setPrice(orderItemDTO.getPrice());
    }

}
