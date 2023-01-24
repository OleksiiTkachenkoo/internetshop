package com.solvd.internetshop.model;

import java.util.Objects;

public class Shipment {

    private int id;
    private String status;
    private String transportName;
    private String date;



    public Shipment() {}

    public Shipment(int id, String status, String transportName, String date) {
        this.id = id;
        this.status = status;
        this.transportName = transportName;
        this.date = date;
    }

    public Shipment(String status, String transportName, String date) {
        this.status = status;
        this.transportName = transportName;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shipment shipment = (Shipment) o;
        return id == shipment.id;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", transportName='" + transportName + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, transportName, date);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransportName() {
        return transportName;
    }

    public void setTransportName(String transportName) {
        this.transportName = transportName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
