package by.epam.finalproject.command.commonCommand;

//import by.epam.finalproject.path.Page;
import by.epam.finalproject.command.ActionCommand;
import by.epam.finalproject.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = //Page.LOGIN;
        ConfigurationManager.getProperty("path.page.index");
        // уничтожение сессии
        request.getSession().invalidate();
        return page;
    }
}