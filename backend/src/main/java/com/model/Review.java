package com.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Review {
    @Id
    private long id_review;

    private String feedback;

    private int rating;

    private LocalDateTime date;

    @OneToOne
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
//    private Order order;

    @Override
    public String toString() {
        return "Review{" +
                "id_review=" + id_review +
                ", feedback='" + feedback + '\'' +
                ", rating=" + rating +
                ", date=" + date +
                ", customer=" + customer +
                '}';
    }
}

