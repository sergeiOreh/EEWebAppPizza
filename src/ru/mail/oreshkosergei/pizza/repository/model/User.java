package ru.mail.oreshkosergei.pizza.repository.model;


import java.util.List;

public class User {
    private Integer idUser;
    private String name;
    private String surname;
    private String username;
    private String password;
    private UserRole role;
    private Integer roleId;

    private User(Builder builder) {
        setIdUser(builder.idUser);
        setName(builder.name);
        setSurname(builder.surname);
        setUsername(builder.username);
        setPassword(builder.password);
        setRole(builder.role);
        setRoleId(builder.roleId);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }


    public User() {
    }

    public static final class Builder {
        private Integer idUser;
        private String name;
        private String surname;
        private String username;
        private String password;
        private UserRole role;
        private Integer roleId;

        private Builder() {
        }

        public Builder idUser(Integer val) {
            idUser = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder surname(String val) {
            surname = val;
            return this;
        }

        public Builder username(String val) {
            username = val;
            return this;
        }

        public Builder password(String val) {
            password = val;
            return this;
        }

        public Builder role(UserRole val) {
            role = val;
            return this;
        }

        public Builder roleId(Integer val) {
            roleId = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
