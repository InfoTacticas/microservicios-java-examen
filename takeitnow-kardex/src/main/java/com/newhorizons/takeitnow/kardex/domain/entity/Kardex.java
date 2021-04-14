package com.newhorizons.takeitnow.kardex.domain.entity;

import java.util.Date;

public class Kardex {
    private Product product;
    private Long quantity;
    private String transactionType;
    private Date transactionDate;

    public Kardex() {
    }

    public Kardex(Product product, Long quantity, String transactionType, Date transactionDate) {
        this.product = product;
        this.quantity = quantity;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}
