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

public class UserOrdersServlet extends HttpServlet {

    private OrderService orderService = OrderServiceImpl.getInstance();
    private OrderItemService orderItemService = OrderItemServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("userName");
        Integer id = orderItemService.getIdUser(userName);
        List<OrderDTO> ordersDTO = orderService.showPizzaOrders(id);
        req.setAttribute("orders", ordersDTO);
        req.getRequestDispatcher("/WEB-INF/pages/buy.jsp").forward(req, resp);
    }


}
