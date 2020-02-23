package com.beanary.bootcamp.java.basic.command;

import java.util.Scanner;

public class Add implements CommandHandler {

    private int[] a;
    private int n;
    private Scanner sc;

    @Override
    public void displayInput() {
        sc = new Scanner(System.in);
        System.out.print("How many numbers? ");
        n = sc.nextInt();

        int i = 0;
        a = new int[n];
        do {
            sc = new Scanner(System.in);
            System.out.printf("Number - %d = ", (i + 1));
            a[i] = sc.nextInt();
            i++;
        } while (i < n);
    }

    @Override
    public void execute() {
        int r = 0;
        for(int i = 0; i < n; i++){
            r = r + a[i];
        }
        System.out.printf("Result = %d \n", r);
    }
}
