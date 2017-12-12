package ru.mail.oreshkosergei.pizza.controller.validator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsernameValidator {
    public static List<String> checkUsername(String username, List<String> errors) {
        Pattern p = Pattern.compile("[A-Za-z0-9]{5,20}"); //доделать
        Matcher m = p.matcher(username);
        if (!m.find()) {
            errors.add("username is not valid. ");
        }
        return errors;
    }
}
