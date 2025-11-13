package com.example.immutables.domain;

import org.springframework.data.relational.core.mapping.Table;

@Table("ORDER_ITEM")
public class OrderItem {

    private final String product;

    private final int quantity;

    public OrderItem(String product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
