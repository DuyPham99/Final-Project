package com.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Order{
    @Id
    private long id_order;

    private int status;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @OneToOne
    @JoinColumn(name = "order_detail_id")
    private Order_Detail orderDetail;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public long getId_order() {
        return id_order;
    }

    public void setId_order(long id_order) {
        this.id_order = id_order;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Order_Detail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(Order_Detail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id_order=" + id_order +
                ", status=" + status +
                ", account=" + account +
                ", payment=" + payment +
                ", orderDetail=" + orderDetail +
                ", customer=" + customer +
                '}';
    }
}
