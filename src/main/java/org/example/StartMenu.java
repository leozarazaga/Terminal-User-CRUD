package org.example;

import java.util.Scanner;

public class StartMenu {


    public static void startMenu() {

        Scanner scanner = new Scanner(System.in);
        boolean isProgramActive;

        System.out.println("\n \t MAIN MENU");
        System.out.println("\t̅ ̅ ̅ ̅ ̅̅ ̅ ̅ ̅ ̅ ̅̅ ̅̅ ");
        System.out.println("1. Add person ");
        System.out.println("2. Get information");
        System.out.println("3. List employees");
        System.out.println("4. List interns");
        System.out.println("5. Exit");
        System.out.print("\nChoose an option: ");


        do {

            int choice = scanner.nextInt();
            isProgramActive = MenuChoice.menuChoice(choice);

        } while (isProgramActive);


    }
}
