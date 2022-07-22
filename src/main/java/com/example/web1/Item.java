package com.example.web1;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;
    private String name;
    @Column(unique = true)
    private long seriesNumber;

    public Item(double price, String name, Long seriesNumber) {
        this.price = price;
        this.name = name;
        this.seriesNumber = seriesNumber;
    }
    public Item(){}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Long getSeriesNumber() {
        return seriesNumber;
    }
}
