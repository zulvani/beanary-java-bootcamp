package com.beanary.bootcamp.java.basic.command;

import java.util.Scanner;

public class Div implements CommandHandler {

    private int a, b;
    private Scanner sc;

    @Override
    public void displayInput() {
        sc = new Scanner(System.in);
        System.out.print("Bilangan 1 ");
        a = sc.nextInt();

        sc = new Scanner(System.in);
        System.out.print("Bilangan 2 ");
        b = sc.nextInt();
    }

    @Override
    public void execute() {
        double r = a / b;
        System.out.printf("Result = %d \n", r);
    }
}
