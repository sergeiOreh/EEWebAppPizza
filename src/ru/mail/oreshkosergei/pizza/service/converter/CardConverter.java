package ru.mail.oreshkosergei.pizza.service.converter;

import ru.mail.oreshkosergei.pizza.repository.model.Card;
import ru.mail.oreshkosergei.pizza.repository.model.Order;
import ru.mail.oreshkosergei.pizza.service.model.CardDTO;
import ru.mail.oreshkosergei.pizza.service.model.OrderDTO;

public class CardConverter {

    public static CardDTO cardToCardDTO(Card card) {
       CardDTO cardDTO = new CardDTO();
       cardDTO.setId(card.getId());
       cardDTO.setNumber(card.getNumber());
       cardDTO.setMonth(card.getMonth());
       cardDTO.setYear(card.getYear());
       cardDTO.setDescription(card.getDescription());
       cardDTO.setUserId(card.getUserId());
        return cardDTO;
    }
}
