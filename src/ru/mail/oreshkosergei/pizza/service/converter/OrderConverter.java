package ru.mail.oreshkosergei.pizza.service.converter;

import ru.mail.oreshkosergei.pizza.repository.model.Order;
import ru.mail.oreshkosergei.pizza.service.model.OrderDTO;

public class OrderConverter {
    public static Order orderDTOToOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setFirstName(orderDTO.getFirstName());
        order.setSurname(orderDTO.getSurname());
        order.setOrderPizzaName(orderDTO.getOrderPizzaName());
        order.setOrderPriceOnePizza(orderDTO.getOrderPriceOnePizza());
        order.setQuantity(orderDTO.getQuantity());
        order.setStatus(orderDTO.getStatus());
        return order;
    }

    public static OrderDTO orderToOrderDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setFirstName(order.getFirstName());
        orderDTO.setSurname(order.getSurname());
        orderDTO.setOrderPizzaName(order.getOrderPizzaName());
        orderDTO.setOrderPriceOnePizza(order.getOrderPriceOnePizza());
        orderDTO.setQuantity(order.getQuantity());
        orderDTO.setStatus(order.getStatus());
        return orderDTO;
    }
}
