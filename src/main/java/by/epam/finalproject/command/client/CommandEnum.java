package by.epam.finalproject.command.client;

import by.epam.finalproject.command.ActionCommand;
import by.epam.finalproject.command.LoginCommand;
import by.epam.finalproject.command.LogoutCommand;

public enum  CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    };
    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }
}
