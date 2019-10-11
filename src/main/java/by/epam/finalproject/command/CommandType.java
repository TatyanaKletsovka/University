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
            this.command = new ShowAllApplications();
        }
    },
    SHOW_ALL_FACULTIES {
        {
            this.command = new ShowAllFaculties();
        }
    },
    GO_TO_APPLICATION_PAGE {
        {
            this.command = new GoToApplicationPage();
        }
    },
    CREATE_APPLICATION {
        {
            this.command = new CreateApplication();
        }
    },
    SHOW_MY_APPLICATIONS {
        {
            this.command = new ShowMyApplications();
        }
    },
    DELETE_APPLICATION {
        {
            this.command = new DeleteApplication();
        }
    },
    SHOW_ALL_USERS {
        {
            this.command = new ShowAllUsers();
        }
    },
    PROCESS_APPLICATIONS {
        {
            this.command = new ProcessApplications();
        }
    };
    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }
}
