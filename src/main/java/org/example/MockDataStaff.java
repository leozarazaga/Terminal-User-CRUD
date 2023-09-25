package org.example;

import java.time.LocalDate;
public class MockDataStaff {

    public static void addingMockDataOfStaff() {


        Employee employee1 = new Employee(GenerateRandomID.generateRandomID(), "female", "Jeffrey Bridges", LocalDate.of(2018, 9, 5), 30000, 1);
        Employee employee2 = new Employee(GenerateRandomID.generateRandomID(), "male", "Alva Nordström", LocalDate.of(2022, 10, 15), 20000, 2);
        Employee employee3 = new Employee(GenerateRandomID.generateRandomID(), "male", "Leo Winston", LocalDate.of(2018, 10, 30), 20000, 3);
        Employee employee4 = new Employee(GenerateRandomID.generateRandomID(), "female", "Kim Johnson", LocalDate.of(2023, 9, 1), 30000, 4);
        Employee employee5 = new Employee(GenerateRandomID.generateRandomID(), "female", "Kimberly Olsson", LocalDate.of(2022, 11, 2), 40000, 5);
        Employee employee6 = new Employee(GenerateRandomID.generateRandomID(), "female", "Lina Luna", LocalDate.of(2019, 11, 20), 40000, 6);

        Employee.employeeList.add(employee1);
        Employee.employeeList.add(employee2);
        Employee.employeeList.add(employee3);
        Employee.employeeList.add(employee4);
        Employee.employeeList.add(employee5);
        Employee.employeeList.add(employee6);

        Intern intern1 = new Intern(GenerateRandomID.generateRandomID(), "male", "Johan Jarnstam", LocalDate.of(2024, 5, 5), "Superb intern.",7);
        Intern intern2 = new Intern(GenerateRandomID.generateRandomID(), "female", "Martina Tesseri", LocalDate.of(2024, 6, 7), "Very good.",8);
        Intern intern3 = new Intern(GenerateRandomID.generateRandomID(), "female", "Camilla Retis", LocalDate.of(2024, 11, 15), "Good efforts.",9);
        Intern intern4 = new Intern(GenerateRandomID.generateRandomID(), "male", "Alexander Almström", LocalDate.of(2024, 10, 25), "Excellent!",10);

        Intern.internList.add(intern1);
        Intern.internList.add(intern2);
        Intern.internList.add(intern3);
        Intern.internList.add(intern4);

    }
}
