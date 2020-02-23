package com.beanary.bootcamp.java.basic.command;

public class Command {

    private int id;
    private String name;
    private CommandHandler commandHandler;

    public Command(int id, String name, CommandHandler commandHandler) {
        this.id = id;
        this.name = name;
        this.commandHandler = commandHandler;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CommandHandler getCommandHandler() {
        return commandHandler;
    }

    public void setCommandHandler(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

}
