package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Shipping {
    @Id
    private long id_shipping;

    private String shipVia;

    private LocalDateTime start_time;

    private LocalDateTime end_time;

    private String description;

    private int status;

    public long getId_shipping() {
        return id_shipping;
    }

    public void setId_shipping(long id_shipping) {
        this.id_shipping = id_shipping;
    }

    public String getShipVia() {
        return shipVia;
    }

    public void setShipVia(String shipVia) {
        this.shipVia = shipVia;
    }

    public LocalDateTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    public LocalDateTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalDateTime end_time) {
        this.end_time = end_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Shipping{" +
                "id_shipping=" + id_shipping +
                ", shipVia='" + shipVia + '\'' +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
