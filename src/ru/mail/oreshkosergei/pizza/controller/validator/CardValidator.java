package ru.mail.oreshkosergei.pizza.controller.validator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardValidator {
    public static boolean checkNumber(Integer number) {
        String numb = number.toString();
        Pattern p = Pattern.compile("[0-9]{4}[//-][0-9]{4}[//-][0-9]{4}[//-][0-9]{4}[//-]");
        Matcher m = p.matcher(numb);
        return m.find();
    }
}
