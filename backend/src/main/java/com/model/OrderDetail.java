package com.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_order_detail;

    private float price;

    private long discount;

    private int amount;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    Order order;
}
