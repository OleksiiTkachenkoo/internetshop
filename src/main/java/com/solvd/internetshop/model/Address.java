package com.solvd.internetshop.model;

import java.util.Objects;

public class Address {

    private int id;
    private String country;
    private String city;
    private String street;
    private String apartment;
    private int idUser;
    private int idShipment;



    public Address() {}

    public Address(String country, String city, String street,
                   String apartment, int idUser, int idShipment) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.apartment = apartment;
        this.idUser = idUser;
        this.idShipment = idShipment;
    }

    public Address(int id, String country, String city, String street,
                   String apartment, int idUser, int idShipment) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
        this.apartment = apartment;
        this.idUser = idUser;
        this.idShipment = idShipment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, city, street, apartment, idUser, idShipment);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", apartment='" + apartment + '\'' +
                ", idUser=" + idUser +
                ", idShipment=" + idShipment +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdShipment() {
        return idShipment;
    }

    public void setIdShipment(int idShipment) {
        this.idShipment = idShipment;
    }
}
