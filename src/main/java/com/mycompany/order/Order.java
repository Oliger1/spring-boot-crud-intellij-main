package com.mycompany.order;

import com.mycompany.user.User;


import javax.persistence.*;
import java.util.Date;

public class Order {

    private Date orderDate;
    // Existing fields of the Order class
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Existing fields of the Order class

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Order() {
    }

    public Order(Date orderDate, User user) {
        this.orderDate = orderDate;
        this.user = user;
    }
// Constructor, getters, setters, and other methods


}
