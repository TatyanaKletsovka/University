package by.epam.finalproject.command.commonCommand;

import by.epam.finalproject.command.ActionCommand;
import by.epam.finalproject.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;


//убрать
public class EmptyCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        /* в случае ошибки или прямого обращения к контроллеру
         * переадресация на страницу ввода логина */
        String page = //Page.LOGIN;
        ConfigurationManager.getProperty("path.page.index");
        return page;
    }
}
