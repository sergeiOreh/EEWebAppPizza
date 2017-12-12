package ru.mail.oreshkosergei.pizza.controller;

import ru.mail.oreshkosergei.pizza.controller.validator.UsernameValidator;
import ru.mail.oreshkosergei.pizza.service.OrderItemService;
import ru.mail.oreshkosergei.pizza.service.OrderItemServiceImpl;
import ru.mail.oreshkosergei.pizza.service.UserService;
import ru.mail.oreshkosergei.pizza.service.UserServiceImpl;
import ru.mail.oreshkosergei.pizza.service.model.RoleDTO;
import ru.mail.oreshkosergei.pizza.service.model.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginServlet extends HttpServlet {

    private UserService userService = UserServiceImpl.getInstance();
    private OrderItemService orderItemService = OrderItemServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();
        session.setAttribute("userName",username);
        String userName = (String) session.getAttribute("userName");

        validate(req, resp, username, password);

        Integer id = orderItemService.getIdUser(userName);
        String role = userService.getRole(id);
        System.out.println("*************" + role);

        if (role.toLowerCase().equals(RoleDTO.ADMIN.toString().toLowerCase())){
            resp.sendRedirect("/admin/orders");
        }else {
            resp.sendRedirect("/user/products");
        }

    }

    private void validate(HttpServletRequest req, HttpServletResponse resp, String username, String password) throws ServletException, IOException {
        List<String> errors = new ArrayList<>();
        UsernameValidator.checkUsername(username, errors);
        if (!errors.isEmpty()) {
            resp.getWriter().write("Errors: " + errors);
        } else {
            if (userService.isUserValid(username, password)) {
                resp.getWriter().write("You are valid user.");
            } else {
                resp.getWriter().write("You are not valid user. Please try again.");
            }
        }
    }

}
