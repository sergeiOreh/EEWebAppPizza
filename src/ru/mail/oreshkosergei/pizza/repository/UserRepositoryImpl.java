package ru.mail.oreshkosergei.pizza.repository;


import ru.mail.oreshkosergei.pizza.repository.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserRepositoryImpl implements UserRepository {

    private static UserRepositoryImpl instance;

    private UserRepositoryImpl() {
    }

    public static final UserRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new UserRepositoryImpl();
        }
        return instance;
    }

    private ConnectionService connectionService = ConnectionServiceImpl.getInstance();

    @Override
    public User getByUserName(String username) {
        Connection connection = connectionService.getConnection();
        if (connection != null) {
            try (PreparedStatement stnt = connection.prepareStatement(
                    "SELECT username, password FROM t_user WHERE username = ?"
            )) {
                stnt.setString(1, username);
                ResultSet rs = stnt.executeQuery();
                if (rs.next()) {
                    return User.newBuilder()
                            .username(rs.getString("username"))
                            .password(rs.getString("password"))
                            .build();
                }

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
    public List<User> getUserInfo() {
        Connection connection = connectionService.getConnection();
        if (connection != null) {
            try (PreparedStatement stnt = connection.prepareStatement(
                    "SELECT first_name, surname FROM t_user"
            )) {
                ResultSet rs = stnt.executeQuery();
                List<User> users = new ArrayList<>();
                while (rs.next()) {
                    users.add(User.newBuilder()
                            .name(rs.getString("first_name"))
                            .surname(rs.getString("surname"))
                            .build());
                }
                return users;

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
    public String getUserRoleById(Integer id) {
        String userRole = null;
        Connection connection = connectionService.getConnection();
        if (connection != null) {
            try (PreparedStatement stnt = connection.prepareStatement(
                    "SELECT t_role.role from t_role join t_user on t_user.role_id = t_role.id where t_user.id = ?"
            )) {
                stnt.setInt(1, id);
                ResultSet rs = stnt.executeQuery();
                if (rs.next()) {
                    userRole = rs.getString("role");

                }
                return userRole;


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
    public User getUserById(Integer id) {
        Connection connection = connectionService.getConnection();
        if (connection != null) {
            try (PreparedStatement stnt = connection.prepareStatement(
                    "SELECT id, first_name, surname, role_id from t_user where t_user.id = ?"
            )) {
                stnt.setInt(1, id);
                ResultSet rs = stnt.executeQuery();
                while (rs.next()) {
                    return User.newBuilder()
                            .idUser(rs.getInt("id"))
                            .name(rs.getString("first_name"))
                            .surname(rs.getString("surname"))
                            .roleId(rs.getInt("role_id"))
                            .build();

                }

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

