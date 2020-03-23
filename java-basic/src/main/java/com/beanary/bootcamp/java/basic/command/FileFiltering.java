package com.beanary.bootcamp.java.basic.command;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileFiltering implements CommandHandler {
    private Scanner sc;
    String filePathSource;
    String filePathResult;
    String filter;

    @Override
    public void displayInput() {
        sc = new Scanner(System.in);
        System.out.print("Full File Source Path (e.g /home/ef/docs/file.txt) ? ");
        filePathSource = sc.nextLine();

        sc = new Scanner(System.in);
        System.out.print("Full File Result Path (e.g /home/ef/docs/result.txt) ? ");
        filePathResult = sc.nextLine();

        sc = new Scanner(System.in);
        System.out.print("Filter: ");
        filter = sc.nextLine();
    }

    @Override
    public void execute() {
        if(filePathResult == null || (filePathResult != null && filePathResult.trim().length() == 0)){
            filePathResult = "./result.txt";
        }

        try {
            File myObj = new File(filePathSource);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.contains(filter)) {
                    System.out.println(data);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
