package br.com.poc.cakeshop_order_service.converter;

import br.com.poc.cakeshop_order_service.domain.entity.Order;
import br.com.poc.cakeshop_order_service.domain.entity.OrderItem;
import br.com.poc.cakeshop_order_service.model.OrderDTO;
import br.com.poc.cakeshop_order_service.model.OrderItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderConverter {

    private final OrderItemConverter orderItemConverter;

    public OrderDTO toDTO(Order order) {
        List<OrderItemDTO> items = order.getItems().stream()
                .map(orderItemConverter::toDTO)
                .collect(Collectors.toList());

        return OrderDTO.builder()
                .id(order.getId())
                .externalId(order.getExternalId())
                .total(order.getTotal())
                .status(order.getStatus())
                .items(items)
                .createAt(order.getCreateAt())
                .updateAt(order.getUpdateAt())
                .build();
    }

    public Order toEntity(OrderDTO orderDTO) {
        List<OrderItem> items = orderDTO.getItems().stream()
                .map(orderItemConverter::toEntity)
                .collect(Collectors.toList());
        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setExternalId(orderDTO.getExternalId());
        order.setCustomer(order.getCustomer());
        order.setTotal(order.getTotal());
        order.setStatus(orderDTO.getStatus());
        order.setItems(items);
        return order;
    }

}
