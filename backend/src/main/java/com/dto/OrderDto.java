package com.dto;

import com.model.Customer;
import com.model.OrderDetail;
import com.model.Payment;
import com.model.Shipping;
import lombok.Data;

import java.util.List;

@Data
public class OrderDto {
    Long idOrder;

    List<OrderDetail> orderDetails;

    Shipping shipping;

    Customer customer;

    Payment payment;

}
