package com.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idCustomer;

    private String name;

    private String address;

    private String phoneNumber;

    private int status;

    @OneToMany(mappedBy = "customer")
    List<Review> reviews = new ArrayList<>();

    public enum STATUS {
        ACTIVE(0), INACTIVE(1);
        int value;

        STATUS(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static String getStatus(int value) {
            for (Customer.STATUS d : Customer.STATUS.values()) {
                if (d.value == value) {
                    return d.name();
                }
            }
            return null;
        }
    }
}
