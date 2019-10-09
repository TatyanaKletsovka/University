package by.epam.finalproject.command.factory;

import by.epam.finalproject.command.ActionCommand;
import by.epam.finalproject.command.commonCommand.EmptyCommand;
import by.epam.finalproject.command.CommandType;
import by.epam.finalproject.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {

    public ActionCommand defineCommand(HttpServletRequest request) {
        //убрать EmptyCommand
        ActionCommand current = new EmptyCommand();
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            // если команда не задана в текущем запросе
            return current;
        }
        // получение объекта, соответствующего команде
        try {
            CommandType currentType = CommandType.valueOf(action.toUpperCase());
            current = currentType.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", action
                    + MessageManager.getProperty("message.wrong_action"));
        }
        return current;
    }
}
