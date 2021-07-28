package com.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "stock")
public class Stock {
    @Id
    private long id_stock;

    @Column
    private long amount;

    @Column
    private LocalDateTime dateInput;

    @Column
    private int status;

    @OneToOne
    @JoinColumn(name = "product_option_id")
    private ProductOption productOption;

    public long getId_stock() {
        return id_stock;
    }

    public void setId_stock(long id_stock) {
        this.id_stock = id_stock;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateInput() {
        return dateInput;
    }

    public void setDateInput(LocalDateTime dateInput) {
        this.dateInput = dateInput;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ProductOption getProductOption() {
        return productOption;
    }

    public void setProductOption(ProductOption productOption) {
        this.productOption = productOption;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id_stock=" + id_stock +
                ", amount=" + amount +
                ", dateInput=" + dateInput +
                ", status=" + status +
                ", productOption=" + productOption +
                '}';
    }
}
