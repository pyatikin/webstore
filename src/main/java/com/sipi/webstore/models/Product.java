package com.sipi.webstore.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;

import java.util.Date;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @Column(name = "productId")
    private int productId;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private  int price;
    @Column(name = "image")
    private String image;

}
