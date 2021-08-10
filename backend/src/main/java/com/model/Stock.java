package com.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "stock")
@Data
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idStock;

    @Column
    private long amount;

    @Column(name = "date_input")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dateInput;

    @Column
    private int status;

    @OneToOne
    @JoinColumn(name = "product_option_id")
    private ProductOption productOption;

    @Override
    public String toString() {
        return "Stock{" +
                "id_stock=" + idStock +
                ", amount=" + amount +
                ", dateInput=" + dateInput +
                ", status=" + status +
                ", productOption=" + productOption +
                '}';
    }
}
