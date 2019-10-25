package by.epam.finalproject.command.userCommand;

import by.epam.finalproject.command.AbstractCommand;
import by.epam.finalproject.command.ActionCommand;
import by.epam.finalproject.exception.DaoException;
import by.epam.finalproject.service.ApplicationService;

import javax.servlet.http.HttpServletRequest;

import static by.epam.finalproject.command.CommandConstant.*;

public class DeleteApplicationCommand extends AbstractCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) throws DaoException {

        String applicationId = request.getParameter(APPLICATION_ID_PARAMETER);

        ApplicationService applicationService = new ApplicationService(proxyConnection.getConnection());
        boolean isDelete = applicationService.deleteApplicationWhereId(applicationId);

        if (isDelete) {
            ShowMyApplicationsCommand showMyApplicationsCommand = new ShowMyApplicationsCommand();
            return showMyApplicationsCommand.execute(request);
        } else {
            return ERROR_JSP;
        }
    }

}
