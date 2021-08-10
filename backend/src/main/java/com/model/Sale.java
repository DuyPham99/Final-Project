package com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSale;

    private long discount;

    private LocalDate dateStart;

    private LocalDate dateEnd;

    @ManyToOne
    @JoinColumn(name = "product_option_id")
    private ProductOption productOption;

    @Override
    public String toString() {
        return "Sale{" +
                "id_sale=" + idSale +
                ", discount=" + discount +
                ", product_option=" + productOption +
                '}';
    }
}
