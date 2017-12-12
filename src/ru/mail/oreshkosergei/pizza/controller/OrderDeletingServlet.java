package ru.mail.oreshkosergei.pizza.controller;

import ru.mail.oreshkosergei.pizza.service.OrderService;
import ru.mail.oreshkosergei.pizza.service.OrderServiceImpl;
import ru.mail.oreshkosergei.pizza.service.model.OrderDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderDeletingServlet extends HttpServlet{

    private OrderService orderService = OrderServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<OrderDTO> ordersDTO = orderService.showUserOrders();
        req.setAttribute("orders", ordersDTO);

        req.getRequestDispatcher("/WEB-INF/pages/buyadmin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.parseInt(req.getParameter("id"));
        orderService.deletePizza(id);
        resp.sendRedirect(req.getContextPath() + "/admin/orders");


    }

}
