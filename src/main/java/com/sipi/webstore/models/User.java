package com.sipi.webstore.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "mail")
    @Email
    private  String mail;
    @Column(name = "phone")
    private String phone;
    @Column(name = "password")
    private String password;
}
