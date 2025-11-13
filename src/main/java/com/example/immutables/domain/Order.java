package com.example.immutables.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Table("ORDERS")
public class Order {

    @Id
    private final Long id;

    private final String customerName;

    @MappedCollection(idColumn = "ORDER_ID")
    private final List<OrderItem> items;

    public Order(Long id, String customerName, List<OrderItem> items) {
        this.id = id;
        this.customerName = customerName;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Order withItems(List<OrderItem> newItems) {
        return new Order(this.id, this.customerName, newItems);
    }
}
