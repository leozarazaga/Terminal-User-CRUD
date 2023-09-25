package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Intern extends Staff {
    private LocalDate endDate;
    private String quitMessage;
    static List<Intern> internList = new ArrayList<>();

    public Intern(String id, String gender, String name, LocalDate endDate, String quitMessage, int staffNumber) {
        super(id, name, gender, staffNumber);
        this.endDate = endDate;
        this.quitMessage = quitMessage;
        //internList.add(this);
    }

    //GETTERS

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getQuitMessage() {
        return quitMessage;
    }


    //SETTERS

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setQuitMessage(String quitMessage) {
        this.quitMessage = quitMessage;
    }

    public static String quitMessage(String message) {
        return message;
    }


    @Override
    public String toString() {
        return "#" + getStaffNumber() +
                ", Name: " + getName() +
                ", Gender: " + getGender() +
                ", End Date: " + getEndDate() +
                ", Quit Message: " + getQuitMessage() +
                ", ID: " + getId();
    }


}
