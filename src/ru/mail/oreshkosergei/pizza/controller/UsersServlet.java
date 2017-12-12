package ru.mail.oreshkosergei.pizza.controller;


import ru.mail.oreshkosergei.pizza.service.UserService;
import ru.mail.oreshkosergei.pizza.service.UserServiceImpl;
import ru.mail.oreshkosergei.pizza.service.model.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UsersServlet extends HttpServlet {

    private UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserDTO> users = userService.getInfo();
        req.setAttribute("users", users);
        req.getRequestDispatcher("/WEB-INF/pages/users.jsp").forward(req, resp);
    }
}
