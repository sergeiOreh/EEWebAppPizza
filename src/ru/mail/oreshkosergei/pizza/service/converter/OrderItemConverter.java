package ru.mail.oreshkosergei.pizza.service.converter;

import ru.mail.oreshkosergei.pizza.repository.model.OrderItem;
import ru.mail.oreshkosergei.pizza.service.model.OrderItemDTO;

public class OrderItemConverter {

    public static OrderItemDTO orderItemToOrderItemDTO(OrderItem orderItem){
        OrderItemDTO orderItemDTO = new OrderItemDTO();
        orderItemDTO.setIdOrderItem(orderItem.getIdOrderItem());
        orderItemDTO.setPizzaName(orderItem.getPizzaName());
        orderItemDTO.setPrice(orderItem.getPrice());
        orderItemDTO.setQuantity(orderItem.getQuantity());
        return orderItemDTO;
    }

    public static OrderItem orderItemDTOToOrderItem(OrderItemDTO orderItemDTO){
        OrderItem orderItem = new OrderItem();
        orderItem.setIdOrderItem(orderItemDTO.getIdOrderItem());
        orderItem.setPizzaName(orderItemDTO.getPizzaName());
        orderItem.setPrice(orderItemDTO.getPrice());
        orderItem.setQuantity(orderItemDTO.getQuantity());
        return  orderItem;
    }
}
