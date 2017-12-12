package ru.mail.oreshkosergei.pizza.controller;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderEditingServlet extends HttpServlet {


    String name;
    Float price;
    Integer quantity;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        name = req.getParameter("name");
        price = Float.parseFloat(req.getParameter("price"));
        quantity = Integer.parseInt(req.getParameter("quantity"));

        resp.sendRedirect(req.getContextPath() + "/user/editing");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setAttribute("name", name);
        req.setAttribute("price", price);
        req.setAttribute("quantity", quantity);
        req.getRequestDispatcher("/WEB-INF/pages/editing.jsp").forward(req, resp);
    }

}
