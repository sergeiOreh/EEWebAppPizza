package ru.mail.oreshkosergei.pizza.repository;

import ru.mail.oreshkosergei.pizza.repository.model.Order;

import java.util.List;

public interface OrderRepository {

    List<Order> showOrders(Integer userId);
    List<Order> getUserOrders();
    void deleteFromCart(Integer id);
    void editStatus(Integer id, String status);
    void putPizzaOrder(Integer userId, String name, Float price, Integer quantity);

}
