package com.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity
@Data
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idShipping;

    @NotEmpty
    private String shipVia;

    @NotEmpty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime startTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime endTime;

    private String description;

    private int status;

    public enum SHIPPING_STATUS{
        PROCESSING(0),
        SENT(1),
        DELIVERY(2),
        SHIPPING(3);

        int value;

        SHIPPING_STATUS(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static String getStatus(int value) {
            for (SHIPPING_STATUS d : SHIPPING_STATUS.values()) {
                if (d.value == value) {
                    return d.name();
                }
            }
            return null;
        }
    }

    @Override
    public String toString() {
        return "Shipping{" +
                "id_shipping=" + idShipping +
                ", shipVia='" + shipVia + '\'' +
                ", start_time=" + startTime +
                ", end_time=" + endTime +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
