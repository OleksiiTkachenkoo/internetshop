package com.solvd.internetshop.model;

import java.util.Objects;

public class Cart {

    private int id;
    private String productItem;
    private String dateAdd;


    public Cart() {}

    public Cart(String productItem, String dateAdd) {
        this.productItem = productItem;
        this.dateAdd = dateAdd;
    }

    public Cart(int id, String productItem, String dateAdd) {
        this.id = id;
        this.productItem = productItem;
        this.dateAdd = dateAdd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return id == cart.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productItem, dateAdd);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", productItem='" + productItem + '\'' +
                ", dateAdd='" + dateAdd + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductItem() {
        return productItem;
    }

    public void setProductItem(String productItem) {
        this.productItem = productItem;
    }

    public String getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(String dateAdd) {
        this.dateAdd = dateAdd;
    }
}
