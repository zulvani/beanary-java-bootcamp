package com.beanary.bootcamp.java.basic.command;

import java.util.Scanner;

public class Exit implements CommandHandler {

    private String name;

    @Override
    public void displayInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input your name: ");
        name = sc.nextLine();
    }

    @Override
    public void execute() {
        System.out.printf("Thanks %s \n", name);
    }
}
