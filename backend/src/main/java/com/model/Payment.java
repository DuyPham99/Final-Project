package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Payment {
    @Id
    private long id_payment;

    private String type;

    private LocalDateTime dateTime;

    private String description;

    private int status;

    public long getId_payment() {
        return id_payment;
    }

    public void setId_payment(long id_payment) {
        this.id_payment = id_payment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
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
        return "Payment{" +
                "id_payment=" + id_payment +
                ", type='" + type + '\'' +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
