package by.epam.finalproject.command;

import by.epam.finalproject.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public interface ActionCommand {

    String execute(HttpServletRequest request) throws ServiceException;

}
