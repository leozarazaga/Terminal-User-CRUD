package org.example;

import java.time.LocalDate;

public class MockDataStaff {
    public static void addingMockDataOfStaff() {

        Employee employee1 = new Employee(1, "female", "Kim Janzen", LocalDate.of(2023, 9, 1), 30000);
        Employee employee2 = new Employee(2, "female", "Lina Luna", LocalDate.of(2023, 11, 20), 40000);
        Employee employee3 = new Employee(3, "male", "Leo Winston", LocalDate.of(2022, 10, 30), 20000);
        Employee employee4 = new Employee(4, "female", "Mimmi Beckman", LocalDate.of(2023, 9, 5), 30000);
        Employee employee5 = new Employee(5, "female", "Martina Oskarsson", LocalDate.of(2023, 11, 2), 40000);
        Employee employee6 = new Employee(6, "male", "Muhammad Ali", LocalDate.of(2022, 10, 15), 20000);

        Employee.employeeList.add(employee1);
        Employee.employeeList.add(employee2);
        Employee.employeeList.add(employee3);
        Employee.employeeList.add(employee4);
        Employee.employeeList.add(employee5);
        Employee.employeeList.add(employee6);

        Intern intern1 = new Intern(7, "male", "Johan Jarnstam", LocalDate.of(2024, 5, 5), "Superb intern.");
        Intern intern2 = new Intern(8, "female", "Fanny Stjerna", LocalDate.of(2024, 6, 7), "Very good job.");
        Intern intern3 = new Intern(9, "female", "Felicia Fernstone", LocalDate.of(2024, 11, 15), "Good efforts.");
        Intern intern4 = new Intern(10, "male", "Alexander Almström", LocalDate.of(2024, 10, 25), "Excellent!");

        Intern.internList.add(intern1);
        Intern.internList.add(intern2);
        Intern.internList.add(intern3);
        Intern.internList.add(intern4);

    }
}
