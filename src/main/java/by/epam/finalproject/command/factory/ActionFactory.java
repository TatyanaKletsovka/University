package by.epam.finalproject.command.factory;

import by.epam.finalproject.command.ActionCommand;
import by.epam.finalproject.command.CommandType;

import javax.servlet.http.HttpServletRequest;

import static by.epam.finalproject.command.CommandConstant.COMMAND_PARAMETER;

public class ActionFactory {

    public ActionCommand defineCommand(HttpServletRequest request) throws IllegalArgumentException{

        String action = request.getParameter(COMMAND_PARAMETER);
        CommandType currentType = CommandType.valueOf(action.toUpperCase());
        ActionCommand current = currentType.getCurrentCommand();

        return current;
    }
}
