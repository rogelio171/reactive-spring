package com.roger.reactivespring.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Purchase {

    private final String name;
    private final String price;
    private final LocalDateTime createAt;

    @Id
    private String id;

    public Purchase(String name, String price, LocalDateTime createAt) {
        this.name = name;
        this.price = price;
        this.createAt = createAt;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }
}
