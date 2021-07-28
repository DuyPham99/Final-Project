package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "product_option")
public class ProductOption {
    @Id
    private long id_product_option;

    private float price;

    private long color;

    private long memory;

    private long storage;

    private String images;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public long getId_product_option() {
        return id_product_option;
    }

    public void setId_product_option(long id_product_option) {
        this.id_product_option = id_product_option;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public long getColor() {
        return color;
    }

    public void setColor(long color) {
        this.color = color;
    }

    public long getMemory() {
        return memory;
    }

    public void setMemory(long memory) {
        this.memory = memory;
    }

    public long getStorage() {
        return storage;
    }

    public void setStorage(long storage) {
        this.storage = storage;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductOption{" +
                "id_product_option=" + id_product_option +
                ", price=" + price +
                ", color=" + color +
                ", memory=" + memory +
                ", storage=" + storage +
                ", images='" + images + '\'' +
                ", product=" + product +
                '}';
    }
}
