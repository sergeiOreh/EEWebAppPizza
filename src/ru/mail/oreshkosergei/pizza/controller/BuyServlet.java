package ru.mail.oreshkosergei.pizza.controller;

import ru.mail.oreshkosergei.pizza.service.OrderItemService;
import ru.mail.oreshkosergei.pizza.service.OrderItemServiceImpl;
import ru.mail.oreshkosergei.pizza.service.OrderService;
import ru.mail.oreshkosergei.pizza.service.OrderServiceImpl;
import ru.mail.oreshkosergei.pizza.service.model.OrderDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class BuyServlet extends HttpServlet {

    private OrderService orderService = OrderServiceImpl.getInstance();
    private OrderItemService orderItemService = OrderItemServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("userName");
        Integer userId = orderItemService.getIdUser(userName);
        String name = req.getParameter("name");
        Float price = Float.parseFloat(req.getParameter("price"));
        Integer quantity = Integer.parseInt(req.getParameter("quantity"));
        orderService.putOrder(userId,name,price,quantity);
        orderService.showPizzaOrders(userId);

        resp.sendRedirect(req.getContextPath() + "/user/orders");////

    }

}
