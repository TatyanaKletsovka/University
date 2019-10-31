package by.epam.finalproject.command.commonCommand;

import by.epam.finalproject.command.AbstractCommand;
import by.epam.finalproject.command.ActionCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.epam.finalproject.command.CommandConstant.MAIN_JSP;

public class LogoutCommand extends AbstractCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {

        HttpSession currentSession = request.getSession();

        proxyConnection.close();

        currentSession.invalidate();

        return MAIN_JSP;
    }
}