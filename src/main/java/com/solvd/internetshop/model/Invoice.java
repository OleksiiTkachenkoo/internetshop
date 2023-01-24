package com.solvd.internetshop.model;


import java.util.Objects;

public class Invoice {

    private int id;
    private String invoiceDate;
    private String statusPaid;


    public Invoice() {}


    public Invoice(String invoiceDate, String statusPaid) {
        this.invoiceDate = invoiceDate;
        this.statusPaid = statusPaid;
    }

    public Invoice(int id, String invoiceDate, String statusPaid) {
        this.id = id;
        this.invoiceDate = invoiceDate;
        this.statusPaid = statusPaid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return id == invoice.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, invoiceDate, statusPaid);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", invoiceDate='" + invoiceDate + '\'' +
                ", statusPaid='" + statusPaid + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getStatusPaid() {
        return statusPaid;
    }

    public void setStatusPaid(String statusPaid) {
        this.statusPaid = statusPaid;
    }
}
