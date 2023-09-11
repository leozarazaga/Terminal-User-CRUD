package org.example;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static org.example.Employee.employeeList;

public class AdditionalInformation {
    static Scanner scanner = new Scanner(System.in);

    public static void additionalInformation() {

        System.out.print("\nAdditional information\n" +
                "̅ ̅ ̅ ̅̅ ̅ ̅ ̅ ̅ ̅̅ ̅̅ ̅ ̅ ̅̅ ̅̅ ̅ ̅̅ ̅̅ ̅ ̅̅ ̅̅ ̅ ̅ \n" +
                "1. Average wage for males/females\n" +
                "2. Ranking of employees from earliest to most recently hired\n" +
                "3. ↩ Back to main menu\n" +
                "\n" +
                "Choose an option: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                calculateAverageWage();
                calculateAverageWageForWomen();
                calculateAverageWageForMen();
                returnToAdditionalInfoMenu();
                break;
            case 2:
                rankingEmployeesFromEarliestToRecent();
                break;
            case 3:
                StartMenu.startMenu();
                break;

            default:
                System.out.println("Invalid choice. Try again.");
                break;
        }
    }

    public static void calculateAverageWage() {
        System.out.println("\nAverage wage\n‾ ‾ ‾ ‾ ‾ ‾ ‾");
        double totalSalary = employeeList.stream().mapToDouble(Employee::getPaycheck).sum();
        double averageSalary = totalSalary / employeeList.size();
        System.out.println("Average wage for all employees are: " + averageSalary);
    }

    public static void calculateAverageWageForWomen() {
        List<Employee> femaleEmployees =
                employeeList.
                        stream().filter(employee -> "female".
                                equals(employee.getGender())).collect(Collectors.toList());

        double totalSalary = femaleEmployees.stream().mapToDouble(Employee::getPaycheck).sum();
        double averageSalary = totalSalary / femaleEmployees.size();
        System.out.println("Average wage for females: " + averageSalary);
    }

    public static void calculateAverageWageForMen() {
        List<Employee> maleEmployees =
                employeeList.
                        stream().filter(employee -> "male".
                                equals(employee.getGender())).collect(Collectors.toList());

        double totalSalary = maleEmployees.stream().mapToDouble(Employee::getPaycheck).sum();
        double averageSalary = totalSalary / maleEmployees.size();
        System.out.println("Average wage for males: " + averageSalary);
    }

    private static void rankingEmployeesFromEarliestToRecent() {
        System.out.println("\nRanking of employees from earliest to recent ⬇\n");

        Collections.sort(employeeList, (employee1, employee2) -> employee1.getStartDate().compareTo(employee2.getStartDate()));
        for (Employee employee : employeeList) {
            System.out.println(employee.getName() + " - " + employee.getStartDate());
        }
        returnToAdditionalInfoMenu();
    }

    private static void returnToAdditionalInfoMenu(){
        System.out.print("\n↩ Press Enter to go back ");
        scanner.nextLine();
        scanner.nextLine();
        AdditionalInformation.additionalInformation();
    }

}
