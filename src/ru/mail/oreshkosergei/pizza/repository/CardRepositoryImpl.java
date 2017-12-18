package ru.mail.oreshkosergei.pizza.repository;

import ru.mail.oreshkosergei.pizza.repository.model.Card;
import ru.mail.oreshkosergei.pizza.repository.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardRepositoryImpl implements CardRepository {
    private static CardRepositoryImpl instance;

    private CardRepositoryImpl() {
    }

    public static final CardRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new CardRepositoryImpl();
        }
        return instance;
    }

    private ConnectionService connectionService = ConnectionServiceImpl.getInstance();

    @Override
    public List<Card> showCardsById(Integer id) {
        Connection connection = connectionService.getConnection();
        System.out.println("!!!!!!!!!!!" + id);
        if (connection != null) {
            try (PreparedStatement stnt = connection.prepareStatement(
                    "SELECT t_card.id, t_card.number, t_card.month, t_card.year, t_card.description, t_card.user_id from t_card join t_user on t_user.id = t_card.user_id where user_id = ?")){

                    stnt.setInt(1, id);
                ResultSet rs = stnt.executeQuery();
                List<Card> cards = new ArrayList<>();
                while (rs.next()) {
                    cards.add(Card.newBuilder()
                            .id(rs.getInt("id"))
                            .number(rs.getInt("number"))
                            .month(rs.getInt("month"))
                            .year(rs.getInt("year"))
                            .description(rs.getString("description"))
                            .userId(rs.getInt("user_id"))
                            .build());
                }
                stnt.execute();
                return cards;

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
    public void addNewCard(Integer userId, Integer number, Integer month, Integer year, String descr) {
        try (Connection connection = connectionService.getConnection()) {
            connection.setAutoCommit(false);
            if (connection != null) {
                try (PreparedStatement stnt = connection.prepareStatement(
                        "INSERT INTO t_card (user_id, number, month, year, description) VALUES (?,?,?,?,?)"
                )) {
                    stnt.setInt(1, userId);
                    stnt.setInt(2, number);
                    stnt.setInt(3, month);
                    stnt.setInt(4, year);
                    stnt.setString(5, descr);
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
