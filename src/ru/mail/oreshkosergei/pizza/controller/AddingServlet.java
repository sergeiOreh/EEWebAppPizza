package ru.mail.oreshkosergei.pizza.controller;

import ru.mail.oreshkosergei.pizza.controller.validator.CardValidator;
import ru.mail.oreshkosergei.pizza.controller.validator.UsernameValidator;
import ru.mail.oreshkosergei.pizza.service.CardService;
import ru.mail.oreshkosergei.pizza.service.CardServiceImpl;
import ru.mail.oreshkosergei.pizza.service.OrderItemService;
import ru.mail.oreshkosergei.pizza.service.OrderItemServiceImpl;
import ru.mail.oreshkosergei.pizza.service.model.CardDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AddingServlet extends HttpServlet{

    private CardService cardService = CardServiceImpl.getInstance();
    private OrderItemService orderItemService = OrderItemServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("userName");
        Integer id = orderItemService.getIdUser(userName);
        Integer number = Integer.parseInt(req.getParameter("number"));

        Integer month = Integer.parseInt(req.getParameter("month"));
        Integer year = Integer.parseInt(req.getParameter("year"));
        String descr = req.getParameter("descr");

        cardService.addCard(id,number,month,year,descr);
        resp.sendRedirect(req.getContextPath() + "/user/cards");            /////////Доделать

        if (CardValidator.checkNumber(number)){


        }else {
            req.setAttribute("error", "number is not correct");
            req.getRequestDispatcher("/WEB-INF/pages/error.jsp");
        }

    }








}
