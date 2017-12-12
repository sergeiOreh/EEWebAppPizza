package ru.mail.oreshkosergei.pizza.service.converter;

import ru.mail.oreshkosergei.pizza.repository.model.User;
import ru.mail.oreshkosergei.pizza.repository.model.UserRole;
import ru.mail.oreshkosergei.pizza.service.model.UserDTO;

public class UserConverter {

    public static UserDTO userToUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setIdUser(user.getIdUser());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());
        userDTO.setRoleId(user.getRoleId());

        return userDTO;
    }


}
