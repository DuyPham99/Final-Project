package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Sale {
    @Id
    private long id_sale;

    private long discount;

    @OneToOne
    @JoinColumn(name = "product_option_id")
    private ProductOption product_option;

    public long getId_sale() {
        return id_sale;
    }

    public void setId_sale(long id_sale) {
        this.id_sale = id_sale;
    }

    public long getDiscount() {
        return discount;
    }

    public void setDiscount(long discount) {
        this.discount = discount;
    }

    public ProductOption getProduct_option() {
        return product_option;
    }

    public void setProduct_option(ProductOption product_option) {
        this.product_option = product_option;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id_sale=" + id_sale +
                ", discount=" + discount +
                ", product_option=" + product_option +
                '}';
    }
}
