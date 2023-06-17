package com.mycompany.product;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 45)
    private String name;

    @Column(nullable = false)
    private double price;

    // Constructor, getters, setters, and other methods

    public Product() {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
