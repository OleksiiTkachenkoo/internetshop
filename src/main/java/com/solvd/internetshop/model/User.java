package com.solvd.internetshop.model;

import java.util.Objects;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String password;
    private String email;
    private int age;



    public User(){}

    public User(int id, String firstName, String lastName,
                String phone, String password, String email, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.password = password;
        this.email = email;
        this.age = age;
    }

    public User(String firstName, String lastName,
                String phone, String password, String email, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.password = password;
        this.email = email;
        this.age = age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phone, password, email, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
