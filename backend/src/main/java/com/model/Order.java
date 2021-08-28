package com.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "[order]")
public class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idOrder;

    private int status;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @OneToMany( mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_id")
    private Shipping shipping;

    public enum STATUS {
        PENDING(0), PROCESS(1), SHIPPING(2), RECEIVED(3);

        int value;

        STATUS(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
