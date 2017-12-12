package ru.mail.oreshkosergei.pizza.controller;

import ru.mail.oreshkosergei.pizza.service.OrderService;
import ru.mail.oreshkosergei.pizza.service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ChangeStatusServlet extends HttpServlet {

    private OrderService orderService = OrderServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String status = req.getParameter("status");
        orderService.changeStatus(id,status);

        resp.sendRedirect(req.getContextPath() + "/admin/orders");

    }
}
