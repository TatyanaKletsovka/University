package by.epam.finalproject.command;

import by.epam.finalproject.resource.MessageManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.jstl.core.Config;
import java.util.Locale;

import static by.epam.finalproject.resource.MessageManager.DEFAULT_LOCALE;

public class ChangeLanguageCommand implements ActionCommand {

    private static final String RU_LANGUAGE = "ru";
    private static final String US_LANGUAGE = "en";
    private static final String BY_LANGUAGE = "by";

    private static final String RU_COUNTRY = "RU";
    private static final String US_COUNTRY = "US";
    private static final String BY_COUNTRY = "BY";

    /**
     * Implementation of commands to change language.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public String execute(HttpServletRequest request) {

        String localeValue = request.getParameter("locale");
        Locale locale;
        switch (localeValue) {
            case RU_LANGUAGE: {
                locale = new Locale(RU_LANGUAGE, RU_COUNTRY);
                break;
            }
            case US_LANGUAGE: {
                locale = new Locale(US_LANGUAGE, US_COUNTRY);
                break;
            }
            case BY_LANGUAGE: {
                locale = new Locale(BY_LANGUAGE, BY_COUNTRY);
                break;
            }
            default: {
                locale = DEFAULT_LOCALE;
                break;
            }
        }
        Config.set(request.getSession(), Config.FMT_LOCALE, locale);
        MessageManager.changeLocale(locale);

        return "/jsp/main.jsp";

    }
}
