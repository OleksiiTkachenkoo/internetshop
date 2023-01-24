package com.solvd.internetshop.model;

import java.util.Objects;

public class Account {

    private int id;
    int idUser;
    int idUserRole;


    public Account() {}

    public Account(int idUser, int idUserRole) {
        this.idUser = idUser;
        this.idUserRole = idUserRole;
    }

    public Account(int id, int idUser, int idUserRole) {
        this.id = id;
        this.idUser = idUser;
        this.idUserRole = idUserRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", idUserRole=" + idUserRole +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idUser, idUserRole);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdUserRole() {
        return idUserRole;
    }

    public void setIdUserRole(int idUserRole) {
        this.idUserRole = idUserRole;
    }
}
