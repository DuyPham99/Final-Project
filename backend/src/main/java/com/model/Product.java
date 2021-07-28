package com.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "product")
public class Product {
    @Id
    private long id_product;

    private String name;

    private String description;

    private LocalDate published;

    @OneToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany
    @JoinColumn(name = "review_id")
    private List<Review> reviews;

    public long getId_product() {
        return id_product;
    }

    public void setId_product(long id_product) {
        this.id_product = id_product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPublished() {
        return published;
    }

    public void setPublished(LocalDate published) {
        this.published = published;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id_product=" + id_product +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", published=" + published +
                '}';
    }
}
