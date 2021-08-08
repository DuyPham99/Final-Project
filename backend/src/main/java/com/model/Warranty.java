package com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Warranty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idWarranty;

    private long duration;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    @Override
    public String toString() {
        return "Warranty{" +
                "id_warranty=" + idWarranty +
                ", duration=" + duration +
                ", product=" + product +
                '}';
    }
}
