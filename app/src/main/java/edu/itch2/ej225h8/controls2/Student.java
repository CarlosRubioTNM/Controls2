package edu.itch2.ej225h8.controls2;

public class Student {
    private String name;
    private String stdID;
    private int imageID;

    public Student(String name, String stdID, int imageID) {
        this.name = name;
        this.stdID = stdID;
        this.imageID = imageID;
    }

    public String getName() {
        return name;
    }

    public String getStdID() {
        return stdID;
    }

    public int getImageID() {
        return imageID;
    }
}
