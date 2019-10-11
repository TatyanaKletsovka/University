package by.epam.finalproject.command.userCommand;

import by.epam.finalproject.command.ActionCommand;
import by.epam.finalproject.exception.DaoException;
import by.epam.finalproject.service.ApplicationService;

import javax.servlet.http.HttpServletRequest;

import static by.epam.finalproject.command.CommandConstant.*;

public class DeleteApplication implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) throws DaoException {

        String applicationId = request.getParameter(APPLICATION_ID_PARAMETER);

        ApplicationService applicationService = new ApplicationService();
        boolean isDelete = applicationService.deleteApplicationWhereId(applicationId);

        if (isDelete) {
            return MAIN_JSP;
        } else {
            return ERROR_JSP;
        }
    }

}
