package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import static org.example.Intern.internList;

public class InternMenu {
    static Scanner scanner = new Scanner(System.in);

    public static void internMenu() {

        System.out.println("\nInterns\n‾‾‾‾‾‾‾");
        System.out.print("1. View all interns\n" +
                "2. Add intern\n" +
                "3. Modify intern\n" +
                "4. Remove intern\n" +
                "5. ↩ Back to main menu\n" +
                "\n" +
                "Choose an option: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                viewAllInterns();
                break;
            case 2:
                addIntern();
                break;
            case 3:
                modifyIntern();
                break;
            case 4:
                removeIntern();
                break;
            case 5:
                StartMenu.startMenu();
                break;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }

    public static void viewAllInterns() {
        System.out.println("\nView all interns\n̅  ̅  ̅  ̅̅  ̅  ̅  ̅  ̅  ̅ ");
        System.out.println("All interns in the system: " + internList.size() + "\n");
        for (Intern intern : internList) {
            System.out.println(intern);
        }
        returnToInternMenu();
    }

    public static void addIntern() {
        System.out.print("\nEnter ID of the new intern: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter gender of the intern (male/female): ");
        String gender = scanner.nextLine();
        System.out.print("Enter name of the intern (Firstname Surname): ");
        String name = scanner.nextLine();
        System.out.print("Enter the end date of the internship: (yyyy-mm-dd) ");
        String date = scanner.nextLine();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate endDate = LocalDate.parse(date, dateFormatter);
        System.out.print("Enter a quit message for the intern: ");
        String quitMessage = scanner.nextLine();

        Intern intern = new Intern(id, gender, name, endDate, quitMessage);
        Intern.internList.add(intern);
        System.out.println("\nNew intern added: " + intern);
        returnToInternMenu();
    }

    public static void removeIntern() {
        System.out.println("\nRemove intern\n‾ ‾ ‾ ‾ ‾ ‾ ‾");

        for (Intern intern : internList) {
            System.out.println(intern);
        }

        System.out.print("\nEnter the ID of the intern you want to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Intern intern : internList) {
            if (intern.getId() == id) {
                internList.remove(intern);
                System.out.println("Intern: " + intern.getName() + " has been removed.");
                returnToInternMenu();
                return;
            }
        }
        System.out.println("Intern with ID " + id + " not found. Try again.");
        removeIntern();
    }

    public static void modifyIntern() {
        System.out.println("\nModify intern\n‾ ‾ ‾ ‾ ‾ ‾ ‾");

        for (Intern intern : internList) {
            System.out.print(intern);
        }

        System.out.print("\nEnter the intern ID you would like to modify: ");
        int modifyInternID = scanner.nextInt();

        for (Intern intern : internList) {
            if (intern.getId() == modifyInternID) {
                System.out.println("Modifying: " + intern);

                System.out.print("Enter a gender (male/female): ");
                String newGender = scanner.next();
                intern.setGender(newGender);

                System.out.print("Enter a new name: ");
                scanner.nextLine();
                String newName = scanner.nextLine();
                intern.setName(newName);

                System.out.print("Enter a new end date (yyyy-mm-dd): ");
                String endDateInput = scanner.next();
                LocalDate endDate = LocalDate.parse(endDateInput, DateTimeFormatter.ISO_LOCAL_DATE);
                intern.setEndDate(endDate);

                System.out.print("Enter a new message: ");
                scanner.nextLine();
                String quitMessage = scanner.nextLine();
                intern.setQuitMessage(quitMessage);

                System.out.println("Updated intern: " + intern);
                returnToInternMenu();
            }
            System.out.print("Intern with ID " + modifyInternID + " not found. Try again.");
            modifyIntern();
        }
    }

    private static void returnToInternMenu() {
        System.out.print("\n↩ Press Enter to go back ");
        scanner.nextLine();
        scanner.nextLine();
        InternMenu.internMenu();
    }


}
