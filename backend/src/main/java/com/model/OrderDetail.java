package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class OrderDetail {
    @Id
    private long id_order_detail;

    private float price;

    private long discount;

    private int amount;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public long getId_order_detail() {
        return id_order_detail;
    }

    public void setId_order_detail(long id_order_detail) {
        this.id_order_detail = id_order_detail;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public long getDiscount() {
        return discount;
    }

    public void setDiscount(long discount) {
        this.discount = discount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Order_Detail{" +
                "id_order_detail=" + id_order_detail +
                ", price=" + price +
                ", discount=" + discount +
                ", amount=" + amount +
                ", product=" + product +
                '}';
    }
}
