package by.epam.finalproject.command;

import by.epam.finalproject.pool.ProxyConnection;

public abstract class AbstractCommand {

    protected ProxyConnection proxyConnection;

    public AbstractCommand() {
        this.proxyConnection = new ProxyConnection();
    }

}
