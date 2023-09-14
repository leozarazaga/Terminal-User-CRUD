package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Intern extends Staff {
    private LocalDate endDate;
    private String quitMessage;
    static List<Intern> internList = new ArrayList<>();

    public Intern(String id, String gender, String name, LocalDate endDate, String quitMessage) {
        super(name, id, gender);
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



    @Override
    public String toString() {
        return "ID: " + getId() +
                ", Name: " + getName() +
                ", Gender: " + getGender() +
                ", End Date: " + getEndDate() +
                ", Quit Message: " + getQuitMessage();
    }


}
