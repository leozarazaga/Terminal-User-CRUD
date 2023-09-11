package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

import static org.example.Employee.employeeList;
import static org.example.Intern.internList;

public class EmployeeMenu {

    static Scanner scanner = new Scanner(System.in);

    public static void employeeMenu() {
        System.out.print("\nEmployee\n" +
                "̅ ̅ ̅ ̅̅ ̅ ̅ ̅ ̅̅ \n" +
                "1. View all employees\n" +
                "2. Add new employee\n" +
                "3. Modify employee\n" +
                "4. Delete employee\n" +
                "5. ↩ Back to main menu\n" +
                "\n" +
                "Choose an option: ");

        int chooseAnOption = scanner.nextInt();
        switch (chooseAnOption) {
            case 1:
                viewAllEmployees();
                break;
            case 2:
                addingAnEmployee();
                break;
            case 3:
                modifyEmployee();
                break;
            case 4:
                deleteEmployee();
                break;
            case 5:
                StartMenu.startMenu();
                break;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }

    public static void viewAllEmployees() {
        System.out.println("\nView all employees");
        System.out.println("‾ ‾ ‾ ‾ ‾ ‾ ‾ ‾ ‾ ‾");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
        goBackToEmployeeOptionMenu();
    }

    private static void addingAnEmployee() {

        System.out.println("\nAdding a new employee");
        System.out.print("ID number: ");
        int employeeID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Gender (female/male): ");
        String employeeGender = scanner.next();

        System.out.print("Employee name: ");
        scanner.nextLine();
        String employeeName = scanner.nextLine();

        LocalDate employeeStartDate = null;
        boolean validDate = false;
        while (!validDate) {
            try {
                System.out.print("Start date (yyyy-mm-dd): ");
                String employeeStartDateInput = scanner.next();
                employeeStartDate = LocalDate.parse(employeeStartDateInput, DateTimeFormatter.ISO_LOCAL_DATE);
                validDate = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Enter a date in yyyy-mm-dd format.");
            }
        }

        System.out.print("Paycheck: ");
        int employeePaycheck = scanner.nextInt();
        scanner.nextLine();

        Employee employee1 = new Employee(employeeID, employeeGender, employeeName, employeeStartDate, employeePaycheck);
        employeeList.add(employee1);
        System.out.println("\nEmployee added!  \n" + employee1);

        goBackToEmployeeOptionMenu();

    }

    public static void deleteEmployee() {
        System.out.println("\nDelete employee");
        System.out.println("‾ ‾ ‾ ‾ ‾ ‾ ‾ ‾");
        System.out.println("Employees in the system:");


        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
        System.out.print("\nEnter the ID of the employee you want to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeList.remove(employee);
                System.out.println("Employee: " + employee.getName() + " has been removed.");
                goBackToEmployeeOptionMenu();
                return;
            }
            System.out.println("Employee with ID " + id + " not found. Try again.");
            deleteEmployee();
        }
    }

    public static void modifyEmployee() {
        System.out.println("\nModify employee");
        System.out.println("‾ ‾ ‾ ‾ ‾ ‾ ‾ ‾");

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

        System.out.print("\nEnter the employee ID you would like to modify: ");
        int modifyEmployeeID = scanner.nextInt();

        for (Employee employee : Employee.employeeList) {
            if (employee.getId() == modifyEmployeeID) {

                System.out.println("Modifying: " + employee);

                System.out.print("Enter a gender (male/female): ");
                String newGender = scanner.next();
                employee.setGender(newGender);

                System.out.print("Enter a new name: ");
                scanner.nextLine();
                String newName = scanner.nextLine();
                employee.setName(newName);

                System.out.print("Enter a new Start date: (yyyy-mm-dd): ");
                String startDateInput = scanner.next();
                LocalDate employeeStartDate = LocalDate.parse(startDateInput, DateTimeFormatter.ISO_LOCAL_DATE);
                employee.setStartDate(employeeStartDate);

                System.out.print("Enter new paycheck: ");
                int newPayCheck = scanner.nextInt();
                employee.setPaycheck(newPayCheck);

                System.out.println("Updated employee: " + employee);
                goBackToEmployeeOptionMenu();
            }
        }
        System.out.println("Employee with ID " + modifyEmployeeID + " not found. Try again.");
        goBackToEmployeeOptionMenu();
    }

    private static void goBackToEmployeeOptionMenu() {
        System.out.print("\n↩ Press Enter to go back ");
        scanner.nextLine();
        scanner.nextLine();
        employeeMenu();
    }


}

