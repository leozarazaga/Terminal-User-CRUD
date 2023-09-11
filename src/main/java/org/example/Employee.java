package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee extends Staff {
    private LocalDate startDate;
    private int paycheck;
    static List<Employee> employeeList = new ArrayList<>();

    public Employee(int id, String gender, String name, LocalDate startDate, int paycheck) {
        super(id, name, gender);
        this.startDate = startDate;
        this.paycheck = paycheck;
    }

    //GETERS
    public LocalDate getStartDate() {
        return startDate;
    }

    public int getPaycheck() {
        return paycheck;
    }

    //SETTERS
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setPaycheck(int paycheck) {
        this.paycheck = paycheck;
    }


    @Override
    public String toString() {
        return "ID: " + getId() +
                ", Name: " + getName() +
                ", Gender: " + getGender() +
                ", Start Date: " + getStartDate() +
                ", Paycheck: " + getPaycheck();
    }
}
