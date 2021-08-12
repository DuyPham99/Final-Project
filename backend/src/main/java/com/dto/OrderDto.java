package com.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDto {
    Long idOrder;

    int status;

    Long idAccount;

    Long idPayment;

    List<Long> listIdOrderDetail;

    Long idCustomer;

    Long idShipping;
}
