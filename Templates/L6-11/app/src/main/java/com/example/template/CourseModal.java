package com.example.template;



public class CourseModal {


    // variables for our coursename,
    // description, tracks and duration, id.
    private String Name;
    private String Phone;
    private String Email;
    private int id;

    // creating getter and setter methods


    public String getName() {
        return Name;
    }

    public String getEmail()
    {
        return Email;
    }

    public void setEmail(String Email)
    {
        this.Email = Email;
    }

    public String getPhone() { return Phone; }

    public void setPhone(String Phone) {this.Phone =Phone;}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    // constructor

    public CourseModal(String Name, String Email, String Phone, String string)
    {
        this.Name = Name;
        this.Phone = Phone;
        this.Email = Email;
    }
}