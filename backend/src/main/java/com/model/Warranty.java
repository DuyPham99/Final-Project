package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Warranty {
    @Id
    private long id_warranty;

    private long duration;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public long getId_warranty() {
        return id_warranty;
    }

    public void setId_warranty(long id_warranty) {
        this.id_warranty = id_warranty;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Warranty{" +
                "id_warranty=" + id_warranty +
                ", duration=" + duration +
                ", product=" + product +
                '}';
    }
}
