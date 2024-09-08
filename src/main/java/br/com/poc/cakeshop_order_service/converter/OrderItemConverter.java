package br.com.poc.cakeshop_order_service.converter;

import br.com.poc.cakeshop_order_service.domain.entity.OrderItem;
import br.com.poc.cakeshop_order_service.model.OrderItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderItemConverter {

    private final ProductConverter productConverter;

    public OrderItemDTO toDTO(OrderItem orderItem) {

        return OrderItemDTO.builder()
                .id(orderItem.getId())
                .product(productConverter.toDTO(orderItem.getProduct()))
                .price(orderItem.getPrice())
                .quantity(orderItem.getQuantity())
                .createAt(orderItem.getCreateAt())
                .updateAt(orderItem.getUpdateAt())
                .build();
    }

    public OrderItem toEntity(OrderItemDTO orderItemDTO) {

        OrderItem orderItem = new OrderItem();
        orderItem.setId(orderItemDTO.getId());
        orderItem.setProduct(orderItem.getProduct());
        orderItem.setQuantity(orderItemDTO.getQuantity());
        orderItem.setPrice(orderItemDTO.getPrice());
        return orderItem;
    }
}
