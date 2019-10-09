package by.epam.finalproject.command.commonCommand;

import by.epam.finalproject.command.ActionCommand;
import by.epam.finalproject.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.jstl.core.Config;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            default: {
                locale = DEFAULT_LOCALE;
                break;
            }
        }
        Config.set(request.getSession(), Config.FMT_LOCALE, locale);
        MessageManager.changeLocale(locale);

//        String currentPage = request.getServletPath();
//        boolean isCommonJsp = (checkPath(currentPage, ".*/jsp/common/.*.jsp*")
//                || checkPath(currentPage, ".*/.*.jsp"));
//        if (isCommonJsp || stringEndsWith(currentPage, "login.jsp")
//                || stringEndsWith(currentPage, "register.jsp")) {
//            return "/jsp/common/login.jsp";
//
//        }



        return "/jsp/common/main.jsp";

      //  String command = request.getParameter("command");
      //  return getUrl(command);
    }

    private String getUrl(String command) {
        switch (command) {
            case "show_all_faculties": {
                return "/jsp/general/showAllFaculties.jsp";
            }
            case "show_my_applications": {
                return "/jsp/user/showMyApplications.jsp";
            }
            default: {
                return "/jsp/common/login.jsp";
            }
        }
    }

    private boolean checkPath(String path, String pagePattern) {
        Pattern pattern = Pattern.compile(pagePattern);
        Matcher matcher = pattern.matcher(path);

        return matcher.matches();
    }

    private boolean stringEndsWith(String path, String pagePattern) {
        return path.endsWith(pagePattern);
    }
}
