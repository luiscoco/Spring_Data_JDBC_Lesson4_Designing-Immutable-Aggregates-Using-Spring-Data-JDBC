package com.example.immutables.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.immutables.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
