package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_brand;

    private String name;

    public Long getId_brand() {
        return id_brand;
    }

    public void setId_brand(Long id_brand) {
        this.id_brand = id_brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id_brand=" + id_brand +
                ", name='" + name + '\'' +
                '}';
    }
}
