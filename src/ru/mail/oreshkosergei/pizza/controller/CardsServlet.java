package ru.mail.oreshkosergei.pizza.controller;

import ru.mail.oreshkosergei.pizza.service.CardService;
import ru.mail.oreshkosergei.pizza.service.CardServiceImpl;
import ru.mail.oreshkosergei.pizza.service.OrderItemService;
import ru.mail.oreshkosergei.pizza.service.OrderItemServiceImpl;
import ru.mail.oreshkosergei.pizza.service.model.CardDTO;
import ru.mail.oreshkosergei.pizza.service.model.OrderDTO;
import ru.mail.oreshkosergei.pizza.service.model.OrderItemDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CardsServlet extends HttpServlet {

    private CardService cardService = CardServiceImpl.getInstance();
    private OrderItemService orderItemService = OrderItemServiceImpl.getInstance();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("userName");
        Integer id = orderItemService.getIdUser(userName);
        List<CardDTO> cardsDTO = cardService.showCards(id);
        req.setAttribute("cards", cardsDTO);
        System.out.println(cardsDTO);
        req.getRequestDispatcher("/WEB-INF/pages/cards.jsp").forward(req, resp);
    }





}
