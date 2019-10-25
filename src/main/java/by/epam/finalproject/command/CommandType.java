package by.epam.finalproject.command;

import by.epam.finalproject.command.adminCommand.*;
import by.epam.finalproject.command.commonCommand.*;
import by.epam.finalproject.command.generalCommand.*;
import by.epam.finalproject.command.userCommand.*;

public enum CommandType {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    COMMON_REGISTER {
        {
            this.command = new RegisterCommand();
        }
    },
    COMMON_CHANGE_LANGUAGE {
        {
            this.command = new ChangeLanguageCommand();
        }
    },
    SHOW_ALL_APPLICATIONS {
        {
            this.command = new ShowAllApplicationsCommand();
        }
    },
    SHOW_ALL_FACULTIES {
        {
            this.command = new ShowAllFacultiesCommand();
        }
    },
    GO_TO_APPLICATION_PAGE {
        {
            this.command = new GoToApplicationPageCommand();
        }
    },
    CREATE_APPLICATION {
        {
            this.command = new CreateApplicationCommand();
        }
    },
    SHOW_MY_APPLICATIONS {
        {
            this.command = new ShowMyApplicationsCommand();
        }
    },
    DELETE_APPLICATION {
        {
            this.command = new DeleteApplicationCommand();
        }
    },
    SHOW_ALL_USERS {
        {
            this.command = new ShowAllUsersCommand();
        }
    },
    PROCESS_APPLICATIONS {
        {
            this.command = new ProcessApplicationsCommand();
        }
    };
    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }
}
