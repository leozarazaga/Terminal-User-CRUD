package org.example;

public class Staff {
    private String id;
    private String name;
    private String gender;
    private int staffNumber;

    public Staff(String id, String name, String gender, int staffNumber) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.staffNumber = staffNumber;
    }

    //GETTERS
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getStaffNumber() {
        return staffNumber;
    }


    //SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setStaffNumber(int staffNumber) {
        this.staffNumber = staffNumber;
    }
}
