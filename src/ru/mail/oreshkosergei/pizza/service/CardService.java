package ru.mail.oreshkosergei.pizza.service;

import ru.mail.oreshkosergei.pizza.service.model.CardDTO;
import ru.mail.oreshkosergei.pizza.service.model.OrderDTO;

import java.util.List;

public interface CardService {
    List<CardDTO> showCards(Integer userId);

    void addCard(Integer userId, Integer number, Integer month, Integer year, String descr);
}
