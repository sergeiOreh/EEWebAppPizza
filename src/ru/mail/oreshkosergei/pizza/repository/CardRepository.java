package ru.mail.oreshkosergei.pizza.repository;

import ru.mail.oreshkosergei.pizza.repository.model.Card;

import java.util.List;

public interface CardRepository {
    List <Card> showCardsById (Integer id);
    void  addNewCard(Integer userId,Integer number, Integer month, Integer year, String descr);
}
