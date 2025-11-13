package com.example.immutables;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.immutables.domain.Order;
import com.example.immutables.domain.OrderItem;
import com.example.immutables.repository.OrderRepository;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner demo(OrderRepository orders) {
        return args -> {
            Order initial = new Order(
                null,
                "Alice",
                List.of(
                    new OrderItem("Coffee", 2),
                    new OrderItem("Tea", 1)
                )
            );

            Order saved = orders.save(initial);
            System.out.println("Saved order " + saved.getId() + " for " + saved.getCustomerName());

            orders.findAll().forEach(order -> {
                System.out.println("Order " + order.getId() + " for " + order.getCustomerName());
            });
        };
    }
}
