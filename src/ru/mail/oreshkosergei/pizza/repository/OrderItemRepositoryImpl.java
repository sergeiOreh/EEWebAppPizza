package ru.mail.oreshkosergei.pizza.repository;

import ru.mail.oreshkosergei.pizza.repository.model.Order;
import ru.mail.oreshkosergei.pizza.repository.model.OrderItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderItemRepositoryImpl implements OrderItemRepository {

    private static OrderItemRepositoryImpl instance;

    public OrderItemRepositoryImpl() {
    }

    public static final OrderItemRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new OrderItemRepositoryImpl();
        }
        return instance;
    }

    private ConnectionService connectionService = ConnectionServiceImpl.getInstance();

    public Integer getId(String name) {

        Connection connection = connectionService.getConnection();
        if (connection != null) {
            Integer id = null;
            try (PreparedStatement stnt = connection.prepareStatement(
                    "SELECT id from t_user where username = ?"
            )) {
                stnt.setString(1, name);
                ResultSet rs = stnt.executeQuery();
                if (rs.next()) {
                    id = rs.getInt("id");
                }
                stnt.execute();
                return id;

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }

        return null;
    }

    @Override
    public List<OrderItem> getProducts() {
        Connection connection = connectionService.getConnection();
        if (connection != null) {
            try (PreparedStatement stnt = connection.prepareStatement(
                    "SELECT * FROM t_pizza_item"
            )) {
                ResultSet rs = stnt.executeQuery();
                List<OrderItem> products = new ArrayList<>();
                while (rs.next()) {
                    products.add(OrderItem.newBuilder()
                            .idOrderItem(rs.getInt("id"))
                            .pizzaName(rs.getString("pizza_name"))
                            .price(rs.getFloat("price"))
                            .build());
                }
                return products;

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        return null;
    }


    @Override
    public OrderItem showBasket(Integer id, Integer number) {
        System.out.println("принял");
        System.out.println(id);
        System.out.println(number);
        OrderItem orderItem = null;
        Connection connection = connectionService.getConnection();
        if (connection != null) {
            try (PreparedStatement stnt = connection.prepareStatement(
                    "SELECT * FROM t_pizza_item WHERE id = ?"
            )) {
                stnt.setInt(1, id);
                ResultSet rs = stnt.executeQuery();
                if (rs.next()) {
                    orderItem = OrderItem.newBuilder()
                            .idOrderItem(rs.getInt("id"))
                            .pizzaName(rs.getString("pizza_name"))
                            .price(rs.getFloat("price"))
                            .quantity(number)
                            .build();
                }
                stnt.execute();
                return orderItem;

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }

        return null;
    }


}
