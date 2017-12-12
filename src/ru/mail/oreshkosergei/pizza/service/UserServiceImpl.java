package ru.mail.oreshkosergei.pizza.service;

import ru.mail.oreshkosergei.pizza.repository.UserRepository;
import ru.mail.oreshkosergei.pizza.repository.UserRepositoryImpl;
import ru.mail.oreshkosergei.pizza.repository.model.User;
import ru.mail.oreshkosergei.pizza.repository.model.UserRole;
import ru.mail.oreshkosergei.pizza.service.converter.UserConverter;
import ru.mail.oreshkosergei.pizza.service.model.RoleDTO;
import ru.mail.oreshkosergei.pizza.service.model.UserDTO;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserServiceImpl implements UserService {

    private static UserServiceImpl instance;

    private UserServiceImpl() {
    }

    public static final UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    private UserRepository userRepository = UserRepositoryImpl.getInstance();

    @Override
    public boolean isUserValid(String username, String password) {
        User user = userRepository.getByUserName(username);
        return user != null && Objects.equals(user.getPassword(), password);
    }

    @Override
    public List<UserDTO> getInfo() {
        List<User> users = userRepository.getUserInfo();
        List<UserDTO> usersDTO = new ArrayList<>();
        for (User user : users) {
            System.out.println(user);
            UserDTO userDTO = UserConverter.userToUserDTO(user);
            usersDTO.add(userDTO);
        }
        return usersDTO;
    }

    @Override
    public String getRole(Integer id) {
        String userRole = userRepository.getUserRoleById(id);
        return userRole;
    }

    @Override
    public UserDTO getUser(Integer id) {
        User user = userRepository.getUserById(id);
        Integer i = user.getRoleId();
        switch (i) {
            case 1:
                user.setRole(UserRole.ADMIN);
                break;
            case 2:
                user.setRole(UserRole.USER);
                break;
        }

        UserDTO userDTO = UserConverter.userToUserDTO(user);

        return userDTO;
    }
}
