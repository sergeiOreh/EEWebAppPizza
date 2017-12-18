package ru.mail.oreshkosergei.pizza.service;

import ru.mail.oreshkosergei.pizza.repository.OrderItemRepository;
import ru.mail.oreshkosergei.pizza.repository.OrderItemRepositoryImpl;
import ru.mail.oreshkosergei.pizza.repository.model.OrderItem;
import ru.mail.oreshkosergei.pizza.service.converter.OrderItemConverter;
import ru.mail.oreshkosergei.pizza.service.model.OrderItemDTO;

import java.util.ArrayList;
import java.util.List;

public class OrderItemServiceImpl implements OrderItemService {

    private static OrderItemServiceImpl instance;

    private OrderItemServiceImpl() {
    }

    public static final OrderItemServiceImpl getInstance() {
        if (instance == null) {
            instance = new OrderItemServiceImpl();
        }
        return instance;
    }

    OrderItemRepository orderItemRepository = OrderItemRepositoryImpl.getInstance();

    @Override
    public Integer getIdUser(String userName) {

        Integer userId = orderItemRepository.getId(userName);
        return userId;
    }

    @Override
    public List<OrderItemDTO> getProductInfo() {
        List<OrderItem> products = orderItemRepository.getProducts();
        List<OrderItemDTO> productsDTO = new ArrayList<>();
        for (OrderItem product : products) {
            System.out.println(product);
            OrderItemDTO orderItemDTO = OrderItemConverter.orderItemToOrderItemDTO(product);
            productsDTO.add(orderItemDTO);
        }
        return productsDTO;
    }

    @Override
    public OrderItemDTO showCart(Integer id, Integer number) {
        OrderItem orderItem = orderItemRepository.showBasket(id,number);
        OrderItemDTO orderItemDTO = OrderItemConverter.orderItemToOrderItemDTO(orderItem);

        return orderItemDTO;
    }
}
