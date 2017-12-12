package ru.mail.oreshkosergei.pizza.service;

import ru.mail.oreshkosergei.pizza.repository.model.UserRole;
import ru.mail.oreshkosergei.pizza.service.model.RoleDTO;
import ru.mail.oreshkosergei.pizza.service.model.UserDTO;

import java.util.List;

public interface UserService {

    boolean isUserValid(String username, String password);
    List<UserDTO> getInfo();
    String getRole(Integer id);
    UserDTO getUser(Integer id);

}
