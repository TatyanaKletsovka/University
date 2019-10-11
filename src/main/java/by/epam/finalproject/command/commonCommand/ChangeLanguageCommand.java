package by.epam.finalproject.command.commonCommand;

import by.epam.finalproject.command.ActionCommand;
import by.epam.finalproject.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.jstl.core.Config;
import java.util.Locale;

import static by.epam.finalproject.command.CommandConstant.LOCALE_PARAMETER;
import static by.epam.finalproject.command.CommandConstant.MAIN_JSP;
import static by.epam.finalproject.resource.MessageManager.DEFAULT_LOCALE;

public class ChangeLanguageCommand implements ActionCommand {

    private static final String RU_LANGUAGE = "ru";
    private static final String US_LANGUAGE = "en";

    private static final String RU_COUNTRY = "RU";
    private static final String US_COUNTRY = "US";

    /**
     * Implementation of commands to change language.
     *
     * @param request HttpServletRequest object.
     * @return page.
     */
    @Override
    public String execute(HttpServletRequest request) {

        String localeValue = request.getParameter(LOCALE_PARAMETER);
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
            default: {
                locale = DEFAULT_LOCALE;
                break;
            }
        }
        Config.set(request.getSession(), Config.FMT_LOCALE, locale);
        MessageManager.changeLocale(locale);

        return MAIN_JSP;
    }
}
