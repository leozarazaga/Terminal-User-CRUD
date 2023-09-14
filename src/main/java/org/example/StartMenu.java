package org.example;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static org.example.Employee.employeeList;
import static org.example.Intern.internList;

public class StartMenu {

    static Scanner scanner = new Scanner(System.in);
    static boolean programActive = true;

    public static void startMenu() {
        if (programActive) {
            System.out.println("╔══════════════════════╗");
            System.out.println("  COMMAND CENTRAL LABS");
            System.out.println("╚══════════════════════╝");
            programActive = false;
        }

        System.out.println("\n \t MAIN MENU");
        System.out.println("\t̅ ̅ ̅ ̅ ̅̅ ̅ ̅ ̅ ̅ ̅̅ ̅̅ ");
        System.out.println("1. List of staff");
        System.out.println("2. Employees");
        System.out.println("3. Interns");
        System.out.println("4. Additional information");
        System.out.println("5. Exit");
        System.out.print("\nChoose an option: ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                listOfStaff();
                break;
            case 2:
                EmployeeMenu.employeeMenu();
                break;
            case 3:
                InternMenu.internMenu();
                break;
            case 4:
                AdditionalInformation.additionalInformation();
                break;
            case 5:
                System.out.println("\nClosing program...\nHave a nice day!");
                break;
            default:
                System.out.println("Wrong input!");

        }

    }

    private static void listOfStaff() {
        System.out.println("\nList of staff");
        System.out.println("̅ ̅ ̅̅ ̅ ̅ ̅ ̅ ̅̅ ̅̅ ̅ ̅ ̅̅ ̅ ");

        List<Employee> maleEmployee = employeeList.stream().filter(employee -> "male".equals(employee.getGender())).collect(Collectors.toList());
        List<Employee> femaleEmployee = employeeList.stream().filter(employee -> "female".equals(employee.getGender())).collect(Collectors.toList());

        System.out.println("Total users in the system: " + (employeeList.size() + internList.size()) + "\n");
        System.out.println("Total employees: " + employeeList.size());
        System.out.println("Male employees: " + maleEmployee.size());
        System.out.println("Females employees: " + femaleEmployee.size());


        System.out.println();

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

        System.out.println();

        List<Intern> maleInterns = internList.stream().filter(intern -> "male".equals(intern.getGender())).collect(Collectors.toList());
        List<Intern> femaleInterns = internList.stream().filter(intern -> "female".equals(intern.getGender())).collect(Collectors.toList());

        System.out.println("Total interns in the system: " + internList.size());
        System.out.println("Male interns: " + maleInterns.size());
        System.out.println("Females interns: " + femaleInterns.size() + "\n");

        for (Intern intern : internList) {
            System.out.println(intern);
        }

        goBackToMainMenu();
    }

    private static void goBackToMainMenu() {
        System.out.print("\n↩ Press Enter to go back ");
        scanner.nextLine();
        scanner.nextLine();
        StartMenu.startMenu();
    }

}

