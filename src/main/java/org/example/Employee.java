package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee extends Staff {
    private LocalDate startDate;
    private int paycheck;
    static List<Employee> employeeList = new ArrayList<>();

    public Employee(int id, String name, String gender, LocalDate startDate, int paycheck) {
        super(id, name, gender);
        this.startDate = startDate;
        this.paycheck = paycheck;
        //employeeList.add(this);
        // 'this' is used to reference the current instance of the class,
        // and employeeList.add(this) adds the current Employee object to
        // the list of employees for later retrieval or manipulation.
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
