package ru.mail.oreshkosergei.pizza.controller;

import ru.mail.oreshkosergei.pizza.service.OrderItemService;
import ru.mail.oreshkosergei.pizza.service.OrderItemServiceImpl;
import ru.mail.oreshkosergei.pizza.service.model.OrderItemDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class OrderItemServlet extends HttpServlet {

    private OrderItemService orderItemService = OrderItemServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<OrderItemDTO> products = orderItemService.getProductInfo();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/WEB-INF/pages/products.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("userName");
        orderItemService.getIdUser(userName);
        resp.sendRedirect(req.getContextPath()+"/user/products");

    }


}
