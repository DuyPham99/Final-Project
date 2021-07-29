package com.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class WarrantyHistory {
    @Id
    private long id_warranty_history;

    private String description;

    private LocalDateTime date;

    private int status;

    private String product_id;

//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private Order order;

    public long getId_warranty_history() {
        return id_warranty_history;
    }

    public void setId_warranty_history(long id_warranty_history) {
        this.id_warranty_history = id_warranty_history;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

//    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }
//
//    @Override
//    public String toString() {
//        return "WarrantyHistory{" +
//                "id_warranty_history=" + id_warranty_history +
//                ", description='" + description + '\'' +
//                ", date=" + date +
//                ", status=" + status +
//                ", product_id='" + product_id + '\'' +
//                ", order=" + order +
//                '}';
//    }
}
