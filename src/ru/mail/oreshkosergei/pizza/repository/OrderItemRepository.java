package ru.mail.oreshkosergei.pizza.repository;


import ru.mail.oreshkosergei.pizza.repository.model.OrderItem;

import java.util.List;

public interface OrderItemRepository {

    Integer getId(String userName);
    List<OrderItem> getProducts();
    OrderItem showBasket(Integer id, Integer number);
}
