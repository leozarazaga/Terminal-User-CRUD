package org.example;

public class Staff {
    private int id;
    private String name;
    private String gender;

    public Staff(int id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    //GETTERS
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    //SETTERS

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}
