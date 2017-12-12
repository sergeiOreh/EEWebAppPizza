package ru.mail.oreshkosergei.pizza.repository;

import ru.mail.oreshkosergei.pizza.repository.model.User;
import ru.mail.oreshkosergei.pizza.repository.model.UserRole;

import java.util.List;

public interface UserRepository {
    User getByUserName(String username);

    List<User> getUserInfo();

    String getUserRoleById(Integer id);

    User getUserById(Integer id);
}
