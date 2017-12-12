package ru.mail.oreshkosergei.pizza.service;

import ru.mail.oreshkosergei.pizza.repository.OrderRepository;
import ru.mail.oreshkosergei.pizza.repository.OrderRepositoryImpl;
import ru.mail.oreshkosergei.pizza.repository.model.Order;
import ru.mail.oreshkosergei.pizza.service.converter.OrderConverter;
import ru.mail.oreshkosergei.pizza.service.model.OrderDTO;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private static OrderServiceImpl instance;

    public OrderServiceImpl() {
    }

    public static final OrderServiceImpl getInstance() {
        if (instance == null) {
            instance = new OrderServiceImpl();
        }
        return instance;
    }

    OrderRepository orderRepository = OrderRepositoryImpl.getInstance();

    @Override
    public List<OrderDTO> showPizzaOrders(Integer userId) {
        List<Order> orders = orderRepository.showOrders(userId);
        List<OrderDTO> ordersDTO = new ArrayList<>();
        for (Order order : orders) {
            OrderDTO orderDTO = OrderConverter.orderToOrderDTO(order);
            ordersDTO.add(orderDTO);
        }
        return ordersDTO;
    }

    @Override
    public List<OrderDTO> showUserOrders() {
        List<Order> orders = orderRepository.getUserOrders();
        List<OrderDTO> ordersDTO = new ArrayList<>();
        for (Order order : orders) {
            OrderDTO orderDTO = OrderConverter.orderToOrderDTO(order);
            ordersDTO.add(orderDTO);
        }
        return ordersDTO;
    }



    @Override
    public void deletePizza(Integer id) {
        orderRepository.deleteFromCart(id);
    }

    @Override
    public void changeStatus(Integer id, String status) {
        orderRepository.editStatus(id, status);
    }

    @Override
    public void putOrder(Integer userId, String name, Float price, Integer quantity) {
        orderRepository.putPizzaOrder(userId,name,price,quantity);

    }

}
