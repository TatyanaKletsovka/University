package by.epam.finalproject.command.userCommand;

import by.epam.finalproject.command.ActionCommand;
import by.epam.finalproject.service.ApplicationService;

import javax.servlet.http.HttpServletRequest;

public class DeleteApplication implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) throws Exception {

        String applicationId = request.getParameter("applicationId");
        ApplicationService applicationService = new ApplicationService();
        boolean isDelete = applicationService.deleteApplicationWhereId(applicationId);
        if (isDelete) {
            return "/jsp/common/main.jsp";
        } else {
            return "/jsp/error/error.jsp";
        }
    }

}
