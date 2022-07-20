package ru.flawden.springcourse.models;

import javax.validation.constraints.*;

public class Person {

    private int id;
    @NotEmpty(message = "Firstname shouldn't be empty")
    @Size(min = 2, max = 15, message = "Name shoild be between 2 and 15 characters")
    private String firstname;
    @NotEmpty(message = "Surname shouldn't be empty")
    @Size(min = 2, max = 15, message = "Name shoild be between 2 and 15 characters")
    private String surname;
    @NotEmpty(message = "Email shouldn't be empty")
    @Email(message = "Email shoild be valid")
    @Size(min = 2, max = 15, message = "Name shoild be between 2 and 15 characters")
    private String email;
    @Min(value = 0, message = "User must be alive")
    @Max(value = 150, message = "User must be still alive")
    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {}

    public Person(String firstname, String surname, String email, int age) {
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.age = age;
    }

    public Person(int id, String firstname, String surname, String email, int age) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", " +
                "name: " + firstname + ", " +
                "surname: " + surname + ", " +
                "age: " + age + ", " +
                "email: " + email + ".";
    }
}
