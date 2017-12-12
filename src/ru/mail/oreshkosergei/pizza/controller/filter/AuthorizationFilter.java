package ru.mail.oreshkosergei.pizza.controller.filter;

import ru.mail.oreshkosergei.pizza.repository.model.UserRole;
import ru.mail.oreshkosergei.pizza.service.OrderItemService;
import ru.mail.oreshkosergei.pizza.service.OrderItemServiceImpl;
import ru.mail.oreshkosergei.pizza.service.UserService;
import ru.mail.oreshkosergei.pizza.service.UserServiceImpl;
import ru.mail.oreshkosergei.pizza.service.model.UserDTO;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorizationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    private UserService userService = UserServiceImpl.getInstance();
    private OrderItemService orderItemService = OrderItemServiceImpl.getInstance();

    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        HttpSession session = httpServletRequest.getSession();
        String userName = (String) session.getAttribute("userName");
        Integer id = orderItemService.getIdUser(userName);

        UserDTO userDTO = userService.getUser(id);
        System.out.println(userDTO);
        if (userDTO == null) {
            httpServletResponse.sendRedirect("/login");
        } else {
            String requestURI = httpServletRequest.getRequestURI();
            UserRole role = userDTO.getRole();
            switch (role) {
                case ADMIN:
                    if (requestURI.startsWith("/admin")) {
                        filterChain.doFilter(servletRequest, servletResponse);
                    } else {
                        httpServletResponse.sendRedirect("/admin/orders");
                    }
                    break;
                case USER:
                    if (requestURI.startsWith("/user")) {
                        filterChain.doFilter(servletRequest, servletResponse);
                    } else {
                        httpServletResponse.sendRedirect("/user/products");
                    }
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void destroy() {

    }
}
