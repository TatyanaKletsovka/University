package by.epam.finalproject.command;

import javax.servlet.http.HttpServletRequest;

public interface ActionCommand {

    String COMMAND_PARAMETER = "command";

    String execute(HttpServletRequest request) throws Exception;

}
