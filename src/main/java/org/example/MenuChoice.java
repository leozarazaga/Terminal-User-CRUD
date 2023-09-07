package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static org.example.Employee.employeeList;
import static org.example.Intern.internList;

public class MenuChoice {

    public static boolean menuChoice(int choice) {
        Scanner scanner = new Scanner(System.in);

        switch (choice) {
            case 1:
                System.out.println("\nDo you want to add an employee or an intern?");
                System.out.println("1. Employee");
                System.out.println("2. Intern");

                int employeeOrIntern = scanner.nextInt();
                switch (employeeOrIntern) {

                    case 1:
                        addingAnEmployee(scanner);
                        break;

                    case 2:
                        addingAnIntern(scanner);
                        break;

                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
                break;

            case 2:
                GetInformation.getInformation();
                int chooseAnOption = scanner.nextInt();

                switch (chooseAnOption) {
                    case 1:
                        totalUsersInTheSystem(scanner);
                        break;

                    case 2:
                        calculateAverageWageForMen();
                        break;

                    case 3:
                        System.out.println("\nAverage salary for females: $45450.90");
                        System.out.println(" ↩ Press 1 to go back to 'Get information'");
                        int backToGetInformation3 = scanner.nextInt();
                        if (backToGetInformation3 == 1) {
                            menuChoice(2);
                        }
                        break;

                    case 4:
                        System.out.println("Ranking of employees from earliest to recent...");
                        System.out.println(" ↩ Press 1 to go back to 'Get information'");
                        int backToGetInformation4 = scanner.nextInt();
                        if (backToGetInformation4 == 1) {
                            menuChoice(2);
                        }
                        break;

                    case 5:
                        StartMenu.startMenu();
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
                break;

            case 3:
                System.out.println("\nList of employees");
                System.out.println("̅ ̅ ̅ ̅ ̅̅ ̅ ̅ ̅ ̅ ̅̅ ̅̅ ̅ ̅ ̅ ̅̅ ̅ ̅ ");

                for (Employee employee : employeeList) {
                    System.out.println(employee);
                }

                System.out.print("\n↩ Press Enter to go back ");
                scanner.nextLine();
                StartMenu.startMenu();
                break;

            case 4:
                System.out.println("\nList of interns");
                System.out.println("̅ ̅ ̅ ̅ ̅̅ ̅ ̅ ̅ ̅ ̅̅ ̅̅ ̅ ̅ ̅ ̅ ");

                for (Intern intern : internList) {
                    System.out.println(intern);
                }

                System.out.println("\n↩ Press 1 to Go back");
                int backToMainMenu2 = scanner.nextInt();
                if (backToMainMenu2 == 1) {
                    StartMenu.startMenu();
                }

                break;
            case 5:
                System.out.println("Have a nice day!");
                return false;
            default:
                System.out.println("Wrong input!");
                return true;
        }
        return false;
    }

    private static void totalUsersInTheSystem(Scanner scanner) {

        System.out.println("\nTotal users in the system: " + (employeeList.size() + internList.size()));
        System.out.println();

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

        for (Intern intern : internList) {
            System.out.println(intern);
        }

        goBackToInformationMenu(scanner);
    }


    private static void addingAnEmployee(Scanner scanner) {
        System.out.println("\nAdding a new employee 👤");
        System.out.print("ID number: ");
        int employeeID = scanner.nextInt();

        System.out.print("Employee name: ");
        scanner.nextLine();
        String employeeName = scanner.nextLine();

        System.out.print("Gender (female/male): ");
        String employeeGender = scanner.next();

        System.out.print("Start date: (yyyy-mm-dd) ");
        String employeeStartDateInput = scanner.next();
        LocalDate employeeStartDate = LocalDate.parse(employeeStartDateInput, DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.print("Paycheck: ");
        int employeePaycheck = scanner.nextInt();

        Employee employee1 = new Employee(employeeID, employeeName, employeeGender, employeeStartDate, employeePaycheck);
        employeeList.add(employee1);
        System.out.println("\nEmployee added ☑️  \n" + employee1);

        System.out.println(" ↩ Press 1 to Go back");
        int backToGetInformation0 = scanner.nextInt();
        if (backToGetInformation0 == 1) {
            //menuChoice(2);
            StartMenu.startMenu();
        }
    }

    private static void addingAnIntern(Scanner scanner) {
        System.out.println("\nAdding a new intern 👤");
        System.out.print("ID number: ");
        int internID = scanner.nextInt();

        System.out.print("Intern name: ");
        scanner.nextLine();
        String internName = scanner.nextLine();

        System.out.print("Gender (female/male): ");
        String internGender = scanner.next();

        System.out.print("Start date: (yyyy-mm-dd) ");
        String internEndDateInput = scanner.next();
        LocalDate internEndDate = LocalDate.parse(internEndDateInput, DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.print("Feedback message: ");
        scanner.nextLine();
        String internFeedbackMessage = scanner.nextLine();

        Intern intern1 = new Intern(internID, internName, internGender, internEndDate, internFeedbackMessage);
        internList.add(intern1);
        System.out.println("\nIntern added ☑️  \n" + intern1);

        System.out.println(" ↩ Press 1 to Go back");
        int backToGetInformation0 = scanner.nextInt();
        if (backToGetInformation0 == 1) {
            StartMenu.startMenu();
        }
    }

    private static void calculateAverageWageForMen() {
        List<Employee> maleEmployee = employeeList.stream().filter(employee -> "male".equals(employee.getGender())).collect(Collectors.toList());

        double totalSalary = maleEmployee.stream().mapToDouble(Employee::getPaycheck).sum();
        double averageSalary = totalSalary / maleEmployee.size();
        System.out.println("Average salary for males: " + averageSalary);
        System.out.println("Total Salary for males: " + totalSalary);
        System.out.println("Number of male employees: " + maleEmployee.size());
    }

    private static void goBackToInformationMenu(Scanner scanner) {
        System.out.print("\n↩ Press Enter to go back ");
        scanner.nextLine();
        scanner.nextLine();
        menuChoice(2);
    }
}
