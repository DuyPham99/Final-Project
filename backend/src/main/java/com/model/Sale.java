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
    private ProductOption productOption;

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

    public ProductOption getProductOption() {
        return productOption;
    }

    public void setProductOption(ProductOption product_option) {
        this.productOption = product_option;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id_sale=" + id_sale +
                ", discount=" + discount +
                ", product_option=" + productOption +
                '}';
    }
}
