package ru.mail.oreshkosergei.pizza.repository;

import ru.mail.oreshkosergei.pizza.repository.model.Order;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {

    private static OrderRepositoryImpl instance;

    public OrderRepositoryImpl() {
    }

    public static final OrderRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new OrderRepositoryImpl();
        }
        return instance;
    }

    private ConnectionService connectionService = ConnectionServiceImpl.getInstance();


    @Override
    public List<Order> showOrders(Integer userId) {
        Connection connection = connectionService.getConnection();
        if (connection != null) {
            try (PreparedStatement stnt = connection.prepareStatement(
                    "SELECT t_order.id,t_user.first_name,t_user.surname,t_order.pizza_name,t_order.price,t_order.quantity,t_order.stat from t_order join t_user on t_order.user_id = t_user.id where t_order.user_id=?"
            )) {
                stnt.setInt(1, userId);
                ResultSet rs = stnt.executeQuery();
                List<Order> orders = new ArrayList<>();
                while (rs.next()) {
                    orders.add(Order.newBuilder()
                            .id(rs.getInt("id"))
                            .firstName(rs.getString("first_name"))
                            .surname(rs.getString("surname"))
                            .orderPizzaName(rs.getString("pizza_name"))
                            .orderPriceOnePizza(rs.getFloat("price"))
                            .quantity(rs.getInt("quantity"))
                            .status(rs.getString("stat"))
                            .build());
                }
                stnt.execute();
                return orders;

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
    public List<Order> getUserOrders() {
        Connection connection = connectionService.getConnection();
        if (connection != null) {
            try (PreparedStatement stnt = connection.prepareStatement(
                    "SELECT t_order.id,t_user.first_name,t_user.surname,t_order.pizza_name,t_order.price,t_order.quantity,t_order.stat from t_order join t_user on t_order.user_id = t_user.id"
            )) {
                ResultSet rs = stnt.executeQuery();
                List<Order> orders = new ArrayList<>();
                while (rs.next()) {
                    orders.add(Order.newBuilder()
                            .id(rs.getInt("id"))
                            .firstName(rs.getString("first_name"))
                            .surname(rs.getString("surname"))
                            .orderPizzaName(rs.getString("pizza_name"))
                            .orderPriceOnePizza(rs.getFloat("price"))
                            .quantity(rs.getInt("quantity"))
                            .status(rs.getString("stat"))
                            .build());
                }
                stnt.execute();
                return orders;

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
    public void deleteFromCart(Integer id) {
        try (Connection connection = connectionService.getConnection()) {
            connection.setAutoCommit(false);
            if (connection != null) {
                try (PreparedStatement stnt = connection.prepareStatement(
                        "DELETE FROM t_order WHERE id = ?"
                )) {

                    stnt.setInt(1, id);
                    stnt.execute();

                    connection.commit();
                } catch (SQLException e) {
                    connection.rollback();
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                } finally {
                    if (connection != null) {
                        connection.setAutoCommit(true);
                        connection.close();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editStatus(Integer id, String status) {
        try (Connection connection = connectionService.getConnection()) {
            connection.setAutoCommit(false);
            if (connection != null) {
                try (PreparedStatement stnt = connection.prepareStatement(
                        "UPDATE t_order SET stat=? WHERE id=?"
                )) {
                    stnt.setString(1, status);
                    stnt.setInt(2, id);
                    stnt.execute();

                    connection.commit();
                } catch (SQLException e) {
                    connection.rollback();
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                } finally {
                    if (connection != null) {
                        connection.setAutoCommit(true);
                        connection.close();
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void putPizzaOrder(Integer userId, String name, Float price, Integer quantity) {
        try (Connection connection = connectionService.getConnection()) {
            connection.setAutoCommit(false);
            if (connection != null) {
                try (PreparedStatement stnt = connection.prepareStatement(
                        "INSERT INTO t_order (user_id,pizza_name,price,quantity) VALUES (?,?,?,?)"
                )) {
                    stnt.setInt(1, userId);
                    stnt.setString(2, name);
                    stnt.setFloat(3, price);
                    stnt.setInt(4, quantity);
                    stnt.execute();

                    connection.commit();
                } catch (SQLException e) {
                    connection.rollback();
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                } finally {
                    if (connection != null) {
                        connection.setAutoCommit(true);
                        connection.close();
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

