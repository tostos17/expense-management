package com.pioneers.expense.dto;

import java.math.BigDecimal;

public class ExpenseDto {

    private String productName;
    private String description;
    private String transactionDate;
    private int quantity;
    private BigDecimal cost;

    public ExpenseDto(String productName, String description, String transactionDate, int quantity, BigDecimal cost) {
        this.productName = productName;
        this.description = description;
        this.transactionDate = transactionDate;
        this.quantity = quantity;
        this.cost = cost;
    }

    public ExpenseDto() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
