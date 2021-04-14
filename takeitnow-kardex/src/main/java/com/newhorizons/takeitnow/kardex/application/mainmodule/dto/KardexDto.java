package com.newhorizons.takeitnow.kardex.application.mainmodule.dto;

import java.util.Date;

public class KardexDto {
    private ProductDto product;
    private Long quantity;
    private String transactionType;
    private Date transactionDate;

    public KardexDto() {
    }

    public KardexDto(ProductDto product, Long quantity, String transactionType, Date transactionDate) {
        this.product = product;
        this.quantity = quantity;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
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
