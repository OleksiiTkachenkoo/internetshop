package com.solvd.internetshop.model;

import java.util.Objects;

public class Order {
    private int id;
    private String creationDate;
    private String status;
    private String description;
    private int idUser;
    private int idPayment;




    public Order() {}

    public Order(int id, String creationDate, String status, String description, int idUser, int idPayment) {
        this.id = id;
        this.creationDate = creationDate;
        this.status = status;
        this.description = description;
        this.idUser = idUser;
        this.idPayment = idPayment;
    }

    public Order(String creationDate, String status, String description, int idUser, int idPayment) {
        this.creationDate = creationDate;
        this.status = status;
        this.description = description;
        this.idUser = idUser;
        this.idPayment = idPayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationDate, status, description, idUser, idPayment);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", creationDate='" + creationDate + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", idUser=" + idUser +
                ", idPayment=" + idPayment +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }
}
