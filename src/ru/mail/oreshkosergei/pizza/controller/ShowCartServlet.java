package ru.mail.oreshkosergei.pizza.controller;

import ru.mail.oreshkosergei.pizza.service.OrderItemService;
import ru.mail.oreshkosergei.pizza.service.OrderItemServiceImpl;
import ru.mail.oreshkosergei.pizza.service.model.OrderDTO;
import ru.mail.oreshkosergei.pizza.service.model.OrderItemDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShowCartServlet extends HttpServlet {

    private OrderItemService orderItemService = OrderItemServiceImpl.getInstance();

    Integer id;
    Integer number;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id = Integer.parseInt(req.getParameter("idOrderItem"));
        number = Integer.parseInt(req.getParameter("number"));
        resp.sendRedirect(req.getContextPath() + "/user/cart");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderItemDTO orderItemDTO = orderItemService.showCart(id, number);
        List<OrderItemDTO> orders = new ArrayList<>();
        orders.add(orderItemDTO);
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("/WEB-INF/pages/cart.jsp").forward(req, resp);
    }
}
