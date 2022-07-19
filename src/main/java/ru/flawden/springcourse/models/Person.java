package ru.flawden.springcourse.models;

public class Person {

    private int id;

    private String firstname;

    private String surname;

    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Person() {}

    public Person(String firstname, String surname, String email) {
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
    }

    public Person(int id, String firstname, String surname, String email) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", " +
                "name: " + firstname + ", " +
                "surname: " + surname + ", " +
                "email: " + email + ".";
    }
}
