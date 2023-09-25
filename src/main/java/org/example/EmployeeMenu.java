package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import static org.example.Employee.employeeList;

public class EmployeeMenu {
    static Scanner scanner = new Scanner(System.in);

    public static void employeeMenu() {
        System.out.print("\nEmployee\n" + "̅ ̅ ̅ ̅̅ ̅ ̅ ̅ ̅̅ \n" + "1. View all employees\n" + "2. Add new employee\n" + "3. Modify employee\n" + "4. Delete employee\n" + "5. ↩ Back to main menu\n" + "\n" + "Choose an option: ");

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

    private static void addingAnEmployee() {
        System.out.println("\nAdding a new employee");
        String employeeID = GenerateRandomID.generateRandomID();

        //StaffNumber
        int employeeStaffNumber = 1;
        for (Employee employee : employeeList) {
            if (employee.getStaffNumber() == employeeStaffNumber) {
                employeeStaffNumber++;
            }
        }

        //Adding gender
        String employeeGender = null;
        boolean validGender = false;

        while (!validGender) {
            System.out.print("Gender (male/female/other): ");
            employeeGender = scanner.next();
            if ("male".equalsIgnoreCase(employeeGender) || "female".equalsIgnoreCase(employeeGender) || "other".equalsIgnoreCase(employeeGender)) {
                validGender = true;
            } else {
                System.out.println("Invalid input. Enter 'male', 'female' or 'other'\n");
            }
        }

        //Adding name
        scanner.nextLine();
        String employeeName = null;
        boolean validName = false;

        while (!validName) {
            System.out.print("Employee's full name: ");
            employeeName = scanner.nextLine();
            String[] names = employeeName.split(" ");

            if (names.length == 2 && !names[0].matches(".*\\d.*") && !names[1].matches(".*\\d.*")) {
                validName = true;
            } else {
                System.out.println("Invalid input. Enter both first and last name. Names cannot contain digits.\n");
            }
        }

        //Adding date
        LocalDate employeeStartDate = null;
        boolean validDate = false;
        while (!validDate) {
            try {
                System.out.print("Start date (yyyy-mm-dd): ");
                String employeeStartDateInput = scanner.next();
                employeeStartDate = LocalDate.parse(employeeStartDateInput, DateTimeFormatter.ISO_LOCAL_DATE);
                validDate = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Use yyyy-mm-dd format (example 1992-02-27).\n");
            }
        }

        //Adding paycheck
        int employeePaycheck = 0;
        boolean validPaycheck = false;
        while (!validPaycheck) {
            try {
                System.out.print("Paycheck: ");
                employeePaycheck = scanner.nextInt();
                validPaycheck = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter a valid number for the paycheck.\n");
                scanner.nextLine();
            }
        }

        Employee employee1 = new Employee(employeeID, employeeGender, employeeName, employeeStartDate, employeePaycheck, employeeStaffNumber);
        employeeList.add(employee1);
        System.out.println("\nNew employee successfully added:");
        System.out.println(employee1);
        goBackToEmployeeOptionMenu();
    }

    public static void viewAllEmployees() {
        System.out.println("\nView all employees\n‾ ‾ ‾ ‾ ‾ ‾ ‾ ‾ ‾ ‾");
        System.out.println("All employees in the system: " + employeeList.size() + "\n");

            employeeList.stream()
                    .sorted((a, b) -> Integer.compare(a.getStaffNumber(), b.getStaffNumber()))
                    .forEach(System.out::println);

        goBackToEmployeeOptionMenu();
    }

    public static void modifyEmployee() {
        System.out.println("\nModify employee\n‾ ‾ ‾ ‾ ‾ ‾ ‾ ‾ ‾");

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

        boolean foundEmployee = false;
        do {
            System.out.print("\nWrite the staff number you want to modify: #");
            int staffNumber = scanner.nextInt();
            scanner.nextLine();

            for (Employee employee : employeeList) {
                if (Objects.equals(employee.getStaffNumber(), staffNumber)) {
                    foundEmployee = true;
                    System.out.println("Modifying: " + employee);

                    // Gender
                    String newGender = null;
                    boolean validGender = false;
                    while (!validGender) {
                        System.out.print("\nEnter a gender (male/female/other): ");
                        newGender = scanner.nextLine();

                        if (newGender.equalsIgnoreCase("male") || newGender.equalsIgnoreCase("female") || newGender.equalsIgnoreCase("other")) {
                            validGender = true;
                        } else {
                            System.out.println("Invalid input. Enter 'male', 'female', or 'other'\n");
                        }
                    }
                    employee.setGender(newGender);

                    // New name
                    System.out.print("Enter a new name: ");
                    String newName = scanner.nextLine();
                    employee.setName(newName);

                    // Start date
                    LocalDate employeeStartDate = null;
                    boolean validStartDate = false;
                    while (!validStartDate) {
                        try {
                            System.out.print("Enter a new start date (yyyy-mm-dd): ");
                            String startDateInput = scanner.next();
                            scanner.nextLine();
                            employeeStartDate = LocalDate.parse(startDateInput, DateTimeFormatter.ISO_LOCAL_DATE);
                            validStartDate = true;
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format. Use yyyy-mm-dd format (example 1992-02-27).\n");
                        }
                    }
                    employee.setStartDate(employeeStartDate);

                    // New paycheck
                    int newPaycheck = 0;
                    boolean validPaycheck = false;
                    while (!validPaycheck) {
                        try {
                            System.out.print("Enter new paycheck: ");
                            newPaycheck = scanner.nextInt();
                            validPaycheck = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Enter a valid number for the paycheck.\n");
                            scanner.nextLine();
                        }
                    }
                    employee.setPaycheck(newPaycheck);

                    System.out.print("\nUpdated employee: " + employee);
                    goBackToEmployeeOptionMenu();
                    break;
                }
            } if (!foundEmployee) {
                System.out.println("Employee with staff number " + staffNumber + " not found. Try again.");
            }
        } while (!foundEmployee);
    }

    public static void deleteEmployee() {
        System.out.println("\nDelete employee\n‾ ‾ ‾ ‾ ‾ ‾ ‾ ‾");
        System.out.println("Employees in the system:\n");

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

        System.out.print("\nWrite the staff number you want to delete: #");
        int staffNumber = scanner.nextInt();

        boolean employeeFound = false;

        for (int i = 0; i < employeeList.size(); i++) {
            Employee employee = employeeList.get(i);
            if (Objects.equals(employee.getStaffNumber(), staffNumber)) {
                employeeList.remove(i);
                System.out.println("Employee: " + employee.getName() + " has been removed.");
                employeeFound = true;
                break;
            }
        }

        if (!employeeFound) {
            System.out.println("Employee with staff number " + staffNumber + " not found. Try again.");
            deleteEmployee();
        }

        goBackToEmployeeOptionMenu();
    }

    private static void goBackToEmployeeOptionMenu() {
        System.out.print("\n↩ Press Enter to go back ");
        scanner.nextLine();
        scanner.nextLine();
        employeeMenu();
    }
}

