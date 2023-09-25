package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;
import java.util.Scanner;

import static org.example.Employee.employeeList;
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
                deleteIntern();
                break;
            case 5:
                StartMenu.startMenu();
                break;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }

    public static void addIntern() {
        System.out.println("\nAdding a new intern");
        String internID = GenerateRandomID.generateRandomID();

        //StaffNumber
        int internStaffNumber = 7;
        for (Intern intern : internList) {
            if (intern.getStaffNumber() == internStaffNumber) {
                internStaffNumber++;
            }
        }

        // Adding gender
        String internGender = null;
        boolean validGender = false;
        while (!validGender) {
            System.out.print("Gender (male/female/other): ");
            internGender = scanner.next();
            if ("male".equalsIgnoreCase(internGender) || "female".equalsIgnoreCase(internGender) || "other".equalsIgnoreCase(internGender)) {
                validGender = true;
            } else {
                System.out.println("Invalid input. Enter 'male', 'female' or 'male'.\n");
            }
        }

        // Adding name
        scanner.nextLine();
        String internName = null;
        boolean validName = false;

        while (!validName) {
            System.out.print("Intern's full name: ");
            internName = scanner.nextLine();
            String[] names = internName.split(" ");

            if (names.length == 2 && !names[0].matches(".*\\d.*") && !names[1].matches(".*\\d.*")) {
                validName = true;
            } else {
                System.out.println("Invalid input. Enter both first and last name. Names cannot contain digits.\n");
            }
        }

        // Adding end date
        LocalDate endDate = null;
        boolean validDate = false;
        while (!validDate) {
            try {
                System.out.print("Enter the end date of the internship (yyyy-mm-dd): ");
                String date = scanner.nextLine();
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                endDate = LocalDate.parse(date, dateFormatter);
                validDate = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Use yyyy-mm-dd format (example 1992-02-27).\n");
            }
        }

        // Adding quit message
        System.out.print("Enter a quit message for the intern: ");
        String quitMessage = scanner.next();

        Intern intern1 = new Intern(internID, internGender, internName, endDate, quitMessage, internStaffNumber);
        Intern.internList.add(intern1);
        System.out.println("\nNew intern successfully added:");
        System.out.println(intern1);
        returnToInternMenu();
    }

    public static void viewAllInterns() {
        System.out.println("\nView all interns\n̅  ̅  ̅  ̅̅  ̅  ̅  ̅  ̅  ̅ ");
        System.out.println("All interns in the system: " + internList.size() + "\n");

        internList.stream()
                .sorted((a, b) -> Integer.compare(a.getStaffNumber(), b.getStaffNumber()))
                .forEach(System.out::println);
        returnToInternMenu();
    }

    public static void modifyIntern() {
        System.out.println("\nModify intern\n‾ ‾ ‾ ‾ ‾ ‾ ‾ ‾");

        for (Intern intern : internList) {
            System.out.println(intern);
        }

        boolean foundIntern = false;
        do {
            System.out.print("\nWrite the staff number you want to modify: #");
            int staffNumber = scanner.nextInt();
            scanner.nextLine();

            for (Intern intern : internList) {
                if (Objects.equals(intern.getStaffNumber(), staffNumber)) {
                    foundIntern = true;
                    System.out.println("Modifying: " + intern);

                    // Gender
                    String newGender = null;
                    boolean validGender = false;
                    while (!validGender) {
                        System.out.print("\nEnter a gender (male/female/other): ");
                        newGender = scanner.nextLine();

                        if (newGender.equalsIgnoreCase("male") || newGender.equalsIgnoreCase("female") || newGender.equalsIgnoreCase("other")) {
                            validGender = true;
                        } else {
                            System.out.println("Invalid input. Enter 'male' or 'female'\n");
                        }
                    }
                    intern.setGender(newGender);

                    // New name
                    System.out.print("Enter a new name: ");
                    String newName = scanner.nextLine();
                    intern.setName(newName);

                    // End date
                    LocalDate internEndDate = null;
                    boolean validEndDate = false;
                    while (!validEndDate) {
                        try {
                            System.out.print("Enter a new end date (yyyy-mm-dd): ");
                            String endDateInput = scanner.next();
                            scanner.nextLine();
                            internEndDate = LocalDate.parse(endDateInput, DateTimeFormatter.ISO_LOCAL_DATE);
                            validEndDate = true;
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format. Use yyyy-mm-dd format (example 1992-02-27).\n");
                        }
                    }
                    intern.setEndDate(internEndDate);

                    // New quit message
                    System.out.print("Enter a new quit message: ");
                    String quitMessage = scanner.next();
                    intern.setQuitMessage(quitMessage);

                    System.out.print("\nUpdated intern: " + intern);
                    returnToInternMenu();
                    break;
                }
            }
            if (!foundIntern) {
                System.out.println("Intern with staff number " + staffNumber + " not found. Try again.");
            }
        } while (!foundIntern);
    }

    public static void deleteIntern() {
        System.out.println("\nRemove intern\n‾ ‾ ‾ ‾ ‾ ‾ ‾");
        System.out.println("Interns in the system:");

        for (Intern intern : internList) {
            System.out.println(intern);
        }

        System.out.print("\nWrite the staff number you want to delete: #");
        int staffNumber = scanner.nextInt();


        boolean internFound = false;

        for (Intern intern : internList) {
            if (Objects.equals(intern.getStaffNumber(), staffNumber)) {
                internList.remove(intern);
                System.out.println("Intern: " + intern.getName() + " has been removed.");
                internFound = true;
                break;
            }
        }
        if (!internFound) {
            System.out.println("Intern with ID " + staffNumber + " not found. Try again.");
            deleteIntern();
        }
        returnToInternMenu();
    }

    private static void returnToInternMenu() {
        System.out.print("\n↩ Press Enter to go back ");
        scanner.nextLine();
        scanner.nextLine();
        InternMenu.internMenu();
    }
}
