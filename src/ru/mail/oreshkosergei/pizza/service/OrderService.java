package ru.mail.oreshkosergei.pizza.service;

import ru.mail.oreshkosergei.pizza.service.model.OrderDTO;

import java.util.List;

public interface OrderService {

    List<OrderDTO> showPizzaOrders(Integer userId);
    List<OrderDTO> showUserOrders();

    void deletePizza(Integer id);
    void changeStatus (Integer id, String status);
    void putOrder(Integer userId,String name,Float price,Integer quantity);

}
