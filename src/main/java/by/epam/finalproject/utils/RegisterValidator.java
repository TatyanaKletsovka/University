package by.epam.finalproject.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterValidator {


    private static final String LOGIN_PATTERN = "([a-zA-Z0-9_]+){5,}";
    private static final String PASSWORD_PATTERN = "([a-zA-Z0-9_]+){4,}";
    private static final String NAME_PATTERN = "[A-Za-zА-Яа-я]+";

    public boolean checkData(String login, String password, String firstName, String lastName) {

        boolean isLoginValid = matchPattern(login, LOGIN_PATTERN);
        boolean isPasswordValid = matchPattern(password, PASSWORD_PATTERN);
        boolean isFirstNameValid = matchPattern(firstName, NAME_PATTERN);
        boolean isLastNameValid = matchPattern(lastName, NAME_PATTERN);

        return isLoginValid && isFirstNameValid && isPasswordValid && isLastNameValid;
    }

    private boolean matchPattern(String data, String currentPattern) {
        Pattern pattern = Pattern.compile(currentPattern);
        Matcher matcher = pattern.matcher(data);

        return matcher.matches();
    }

}
