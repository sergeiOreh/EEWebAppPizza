package ru.mail.oreshkosergei.pizza.service;

import ru.mail.oreshkosergei.pizza.repository.CardRepository;
import ru.mail.oreshkosergei.pizza.repository.CardRepositoryImpl;
import ru.mail.oreshkosergei.pizza.repository.OrderItemRepository;
import ru.mail.oreshkosergei.pizza.repository.OrderItemRepositoryImpl;
import ru.mail.oreshkosergei.pizza.repository.model.Card;
import ru.mail.oreshkosergei.pizza.repository.model.Order;
import ru.mail.oreshkosergei.pizza.service.converter.CardConverter;
import ru.mail.oreshkosergei.pizza.service.converter.OrderConverter;
import ru.mail.oreshkosergei.pizza.service.model.CardDTO;
import ru.mail.oreshkosergei.pizza.service.model.OrderDTO;

import java.util.ArrayList;
import java.util.List;

public class CardServiceImpl implements CardService {
    private static CardServiceImpl instance;

    private CardServiceImpl() {
    }

    public static final CardServiceImpl getInstance() {
        if (instance == null) {
            instance = new CardServiceImpl();
        }
        return instance;
    }

    CardRepository cardRepository = CardRepositoryImpl.getInstance();

    @Override
    public List<CardDTO> showCards(Integer userId) {
        List<Card> cards = cardRepository.showCardsById(userId);
        List<CardDTO> cardsDTO = new ArrayList<>();
        for (Card card : cards) {
            CardDTO cardDTO = CardConverter.cardToCardDTO(card);
            cardsDTO.add(cardDTO);
        }
        return cardsDTO;
    }

    @Override
    public void addCard(Integer userId, Integer number, Integer month, Integer year, String descr) {
        cardRepository.addNewCard(userId,number,month,year, descr);
    }
}
