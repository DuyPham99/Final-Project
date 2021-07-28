package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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

//    private Order order;


    public long getId_review() {
        return id_review;
    }

    public void setId_review(long id_review) {
        this.id_review = id_review;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

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

