package com.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity(name = "product_option")
@Data
public class ProductOption {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProductOption;

    private float price;

    private long color;

    private long memory;

    private long storage;

    private String images;

    @OneToOne(mappedBy = "productOption")
    private Sale sale;

    @OneToOne(mappedBy = "productOption")
    private Stock stock;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    @Getter(value = AccessLevel.NONE)
    @JsonBackReference
    @JsonIgnore
    private Product product;

    @Override
    public String toString() {
        return "ProductOption{" +
                "id_product_option=" + idProductOption +
                ", price=" + price +
                ", color=" + color +
                ", memory=" + memory +
                ", storage=" + storage +
                ", images='" + images + '\'' +
                ", product=" + product +
                '}';
    }
}
