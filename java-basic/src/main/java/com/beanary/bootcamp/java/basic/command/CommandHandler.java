package com.beanary.bootcamp.java.basic.command;

public interface CommandHandler {

    /**
     * you can create instantiate object inside this method
     *
     */
    default void pre(){
    }

    /**
     * if your command need input from user, please define it inside this method
     *
     */
    void displayInput();

    /**
     * your command process is here, put your "Business rule" :)
     *
     */
    void execute();
}
