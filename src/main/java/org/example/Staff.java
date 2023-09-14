package org.example;

public class Staff {
    private String id;
    private String name;
    private String gender;

    public Staff(String name, String id, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
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

    //SETTERS
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}
