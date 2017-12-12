package ru.mail.oreshkosergei.pizza.repository;

import java.sql.Connection;

public interface ConnectionService {

    Connection getConnection();
}
