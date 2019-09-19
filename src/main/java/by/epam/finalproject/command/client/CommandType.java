package by.epam.finalproject.command.client;

import by.epam.finalproject.command.*;

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
    COMMON_CHANGE_LANGUAGE {
        {
            this.command = new ChangeLanguageCommand();
        }
    },
    SHOW_ALL_FACULTIES {
        {
            this.command = new ShowAllFaculties();
        }
    };
    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }
}
