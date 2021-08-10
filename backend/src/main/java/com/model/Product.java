package com.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity(name = "product")
@Data
public class Product {
    @Id
    @NotNull
    @NotEmpty
    private long idProduct;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private LocalDate published;

    @OneToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    private int status;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @NotNull
    private List<ProductOption> productOptions = new ArrayList<>();;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @NotNull
    private Warranty warranty;

    @Override
    public String toString() {
        return "Product{" +
                "id_product=" + idProduct +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", published=" + published +
                '}';
    }
}
