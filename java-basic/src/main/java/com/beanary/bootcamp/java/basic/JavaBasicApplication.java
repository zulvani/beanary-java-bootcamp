package com.beanary.bootcamp.java.basic;

import com.beanary.bootcamp.java.basic.command.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class JavaBasicApplication {

	private List<Command> commands = new ArrayList<>();

	private void prepareCommands(){
		commands.add(new Command(0, "Exit", new Exit()));
		commands.add(new Command(1, "Add", new Add()));
		commands.add(new Command(2, "Substract", new Substract()));
		commands.add(new Command(3, "Div", new Div()));
	}

	private void displayCommands(){
		for(Command c : commands){
			System.out.printf("%d %s", c.getId(), c.getName());
			System.out.println();
		}
	}

	private void executeCommand(int c){
		CommandHandler ch = commands.get(c).getCommandHandler();

		if(ch != null) {
			ch.displayInput();
			ch.execute();
		}
	}

	public JavaBasicApplication() {
		prepareCommands();
		displayCommands();

		int choice = -1;

		do {
			Scanner in = new Scanner(System.in);
			System.out.print("Enter your choice: ");

			try {
				choice = in.nextInt();
				executeCommand(choice);
			} catch (Exception e){
				e.printStackTrace();
			}
		} while(choice != 0);
	}

	public static void main(String[] args) {
		SpringApplication.run(JavaBasicApplication.class, args);
	}
}
