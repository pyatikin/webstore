package com.sipi.webstore.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

/// \brief Класс описывающий пользователя в системе
/// Класс который используется как модель для работы с данными всех пользователей,
//          описывает поля пользователя в БД и связывает класс с таблица в БД
@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; /// Поле илентификатор пользователя в БД

    @Column(name = "name")
    private String name; /// Поле имя пользователя в БД

    @Column(name = "mail")
    @Email
    private  String mail; /// Поле почта пользователя в БД
    @Column(name = "phone")
    private String phone; /// Поле телефон пользователя в БД
    @Column(name = "password")
    private String password; /// Поле пароль пользователя в БД

    public Users(String name, String mail, String password) {
        this.name = name;
        this.mail = mail;
        this.password = password;
    }
}
