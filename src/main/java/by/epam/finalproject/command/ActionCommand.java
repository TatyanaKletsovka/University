package by.epam.finalproject.command;

import by.epam.finalproject.exception.DaoException;

import javax.servlet.http.HttpServletRequest;

public interface ActionCommand {

    String execute(HttpServletRequest request) throws DaoException;

}
