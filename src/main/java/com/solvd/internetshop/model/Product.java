package com.solvd.internetshop.model;

import java.util.Objects;

public class Product {

    private int id;
    private String title;
    private int price;
    private String categories;
    private int idUser;
    private int idCart;
    private String availability;
    private int quantity;


    public Product() {}

    public Product(int id, String title, int price, String categories,
                   int idUser, int idCart, String availability, int quantity) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.categories = categories;
        this.idUser = idUser;
        this.idCart = idCart;
        this.availability = availability;
        this.quantity = quantity;
    }

    public Product(String title, int price, String categories,
                   String availability, int quantity) {
        this.title = title;
        this.price = price;
        this.categories = categories;
        this.availability = availability;
        this.quantity = quantity;
    }

    public Product(int id, String title, int price, String categories,
                   String availability, int quantity) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.categories = categories;
        this.availability = availability;
        this.quantity = quantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, categories, availability, quantity);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", categories='" + categories + '\'' +
                ", idOrder=" + idUser +
                ", idCart=" + idCart +
                ", availability='" + availability + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
