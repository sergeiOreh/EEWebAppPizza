package ru.mail.oreshkosergei.pizza.service;

import ru.mail.oreshkosergei.pizza.service.model.OrderItemDTO;

import java.util.List;

public interface OrderItemService {

    Integer getIdUser(String userName);
    List<OrderItemDTO> getProductInfo();
    OrderItemDTO showCart(Integer id,Integer number);

}
