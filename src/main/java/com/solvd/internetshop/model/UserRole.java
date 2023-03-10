package com.solvd.internetshop.model;

import java.util.Objects;

public class UserRole {
    private int id;
    private String role;


    public UserRole() {}

    public UserRole(int id, String role) {
        this.id = id;
        this.role = role;
    }

    public UserRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole1 = (UserRole) o;
        return id == userRole1.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role);
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", userRole='" + role + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
