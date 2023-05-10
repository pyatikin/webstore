package com.sipi.webstore.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    @Column(name = "orderId")
    private int orderId;
    @Column(name = "orderPayId")
    private int orderPayId;
    @Column(name = "productInOrderId")
    private int productInOrderId;
    @Column(name = "sessionUserId")
    private int sessionUserId;
    @Column(name = "userId")
    private  int UserId;
    @Column(name = "orderPrice")
    private  int orderPrice;
    @Column(name = "dateOfOrder")
    private  Date dateOfOrder;
    @Column(name = "addressDelivery")
    private String addressDelivery;
}
